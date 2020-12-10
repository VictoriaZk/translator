package com.example.translator.service;

import com.example.translator.model.WordTranslate;
import com.example.translator.repository.WordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class WordService {
    private final WordRepository wordRepository;

    public void uploadWords(MultipartFile file) throws IOException {
        String documentContent = new String(file.getBytes());
        String[] words = documentContent.split("\n\n");
        for (String word : words) {
            String[] split = word.split("\n");
            String englishWord = split[0];
            String russianWord = split[1];
            if(!wordRepository.findByEnglishWord(englishWord).isPresent()){
                WordTranslate wordTranslate = WordTranslate.builder()
                        .EnglishWord(englishWord)
                        .RussianWord(russianWord)
                        .build();

                wordRepository.save(wordTranslate);
            }
        }

    }
}
