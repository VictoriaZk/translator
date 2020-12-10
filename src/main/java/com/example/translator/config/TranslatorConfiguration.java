package com.example.translator.config;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TranslatorConfiguration.
 *
 * @author Viktoryia Zhak
 */

@Configuration
public class TranslatorConfiguration {
    @Bean
    Translate translate(){
        return TranslateOptions.newBuilder().setTargetLanguage("ru").build().getService();
    }
}
