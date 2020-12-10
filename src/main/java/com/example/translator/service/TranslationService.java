package com.example.translator.service;


import com.example.translator.dto.ShowTranslateResponse;
import com.example.translator.model.TranslateWay;
import com.example.translator.model.TranslatedWord;
import com.example.translator.model.WordTranslate;
import com.example.translator.repository.WordRepository;
import com.example.translator.utils.DocumentUtils;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TranslationService {
    private final Translate translate;
    private final WordRepository wordRepository;

    public ShowTranslateResponse getTranslate(String text){
        List<String[]> collects = DocumentUtils.splitTextBySentencesAndWords(text);

        List<List<TranslatedWord>> translatedSentences = collects.stream().map(sentence -> {
            return Arrays.stream(sentence).map(word -> {
                Optional<WordTranslate> englishWord = wordRepository.findByEnglishWord(word);
                if(englishWord.isPresent()){
                    return TranslatedWord.builder()
                            .word(englishWord.get().getRussianWord())
                            .way(TranslateWay.DATA_BASE)
                            .build();
                }else {
                    Translation translation = translate.translate(word);

                    return TranslatedWord.builder()
                            .word(translation.getTranslatedText())
                            .way(TranslateWay.CLOUD)
                            .build();
                }
            }).collect(Collectors.toList());
        }).collect(Collectors.toList());

        List<TranslatedWord> sortWords = getSortWords(translatedSentences);

        List<TranslatedWord> translatedByDataBase = sortWords.stream()
                .filter(word -> word.getWay().equals(TranslateWay.DATA_BASE))
                .collect(Collectors.toList());

        List<TranslatedWord> translatedByCloud = sortWords.stream()
                .filter(word -> word.getWay().equals(TranslateWay.CLOUD))
                .collect(Collectors.toList());

        return ShowTranslateResponse.builder()
                .translatedText(collectText(translatedSentences))
                .wordsDB(translatedByDataBase)
                .wordsCloud(translatedByCloud)
                .build();
    }

    private String collectText(List<List<TranslatedWord>> text) {
        return text.stream().map(sentence -> {
            return sentence.stream().map(TranslatedWord::getWord).collect(Collectors.joining(" "));
        }).collect(Collectors.joining(". "));
    }

    private List<TranslatedWord> getSortWords(List<List<TranslatedWord>> text) {
        List<TranslatedWord> words = new ArrayList<>();
        text.forEach(words::addAll);

        Map<TranslatedWord, Integer> wordsFrequency = new HashMap<>();

        words.forEach(word -> {
            if(wordsFrequency.containsKey(word)){
                Integer occurrence = wordsFrequency.get(word);
                wordsFrequency.put(word, occurrence);
            }else {
                wordsFrequency.put(word, 1);
            }
        });
        return wordsFrequency.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

}
