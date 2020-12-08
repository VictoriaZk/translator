package com.example.translator.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * DocumentUtils.
 *
 * @author Viktoryia Zhak
 */
public class DocumentUtils {
    public static String getCleanText(String text){
        return text
                .replaceAll("[–,.;:!?]", "")
                .replaceAll("\n", " ")
                .replaceAll("\t", " ")
                .replaceAll("  ( )*", " ").toLowerCase();
    }

    public static String[] getSplitTextBySentences(String text){
        return text.split("[.!?]");
    }

    public static String[] getSplitTextByParagraphs(String text){
        return text.split("\n\n");
    }

    public static String[] getSplitWords(String text){
        return getCleanText(text).split(" ");
    }

    public static Map<String, Integer> getTermsOccurrences(String[] words){

        Map<String, Integer> initialForms = new HashMap<>();

        for (String word : words) {

            if (initialForms.containsKey(word)) {
                initialForms.put(word, initialForms.get(word) + 1);
            } else {
                initialForms.put(word, 1);
            }
        }

        return initialForms;
    }

    public static List<String[]> splitTextBySentencesAndWords(String text){
        String[] splitTextBySentences = getSplitTextBySentences(text);
        List<String[]> fullText = Arrays.stream(splitTextBySentences).map(sentence -> {
            return getSplitWords(getCleanText(sentence));
        }).collect(Collectors.toList());

        return fullText;
    }
}
