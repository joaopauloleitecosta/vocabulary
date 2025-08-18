package com.example.vocabulary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vocabulary.entities.Vocabulary;

public interface VocabularyRepository extends JpaRepository<Vocabulary, Long> {

}
