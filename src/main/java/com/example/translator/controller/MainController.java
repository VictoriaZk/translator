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

    @GetMapping
    public String getTranslate(Model model){
//        String text = "Meet my family. There are five of us – my parents, my elder brother, my baby sister and me. First, meet my mum and dad, Jane and Michael. My mum enjoys reading and my dad enjoys playing chess with my brother Ken. My mum is slim and rather tall. She has long red hair and big brown eyes. She has a very pleasant smile and a soft voice. My mother is very kind and understanding.";
//        ShowTranslateResponse translate = translateService.getTranslate(text);
//        model.addAttribute("translate", translate);
        return "start" ;
    }

    @PostMapping
    public void setWord(@RequestParam(name = "words") MultipartFile file) throws IOException {
        wordService.uploadWords(file);

    }
}
