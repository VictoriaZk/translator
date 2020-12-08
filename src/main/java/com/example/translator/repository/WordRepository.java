package com.example.translator.repository;

import com.example.translator.model.WordTranslate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WordRepository extends JpaRepository<WordTranslate, Long> {

    @Query("SELECT word FROM WordTranslate word WHERE word.EnglishWord = ?1")
    Optional<WordTranslate> findByEnglishWord(String word);
}
