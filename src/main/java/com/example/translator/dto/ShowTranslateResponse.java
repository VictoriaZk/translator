package com.example.translator.dto;

import com.example.translator.model.TranslatedWord;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * ShowTranslateResponse.
 *
 * @author Viktoryia Zhak
 */
@Builder
@Getter
@Setter

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShowTranslateResponse {
    private String translatedText;
    private List<TranslatedWord> wordsDB;
    private List<TranslatedWord> wordsCloud;
}
