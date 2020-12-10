package com.example.translator.controller;

import com.example.translator.dto.ShowTranslateResponse;
import com.example.translator.service.TranslationService;
import com.example.translator.service.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@Controller
@RequestMapping("/translator")
public class MainController {
    private final TranslationService translateService;
    private final WordService wordService;

    @PostMapping
    public String getTranslate(@RequestParam(name = "inputText") String text,  Model model){
        ShowTranslateResponse translate = translateService.getTranslate(text);
        model.addAttribute("translate", translate);
        return "start" ;
    }

    @GetMapping
    public String initPage(){
        return "start";
    }

    @PostMapping("/words")
    public void setWord(@RequestParam(name = "words") MultipartFile file) throws IOException {
        wordService.uploadWords(file);

    }
}
