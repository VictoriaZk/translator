package com.example.translator.model;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Data
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
