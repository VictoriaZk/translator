package com.example.translator.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Getter
@Setter
@Builder

@Entity
public class WordTranslate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String EnglishWord;

    @Column
    private String RussianWord;
}
