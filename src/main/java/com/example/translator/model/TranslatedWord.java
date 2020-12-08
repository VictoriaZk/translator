package com.example.translator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TranslatedWord.
 *
 * @author Viktoryia Zhak
 */

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TranslatedWord {
    private String word;
    private TranslateWay way;
}
