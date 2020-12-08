package com.example.translator.dto;

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
    private List<String> wordsDB;
    private List<String> wordsCloud;


}
