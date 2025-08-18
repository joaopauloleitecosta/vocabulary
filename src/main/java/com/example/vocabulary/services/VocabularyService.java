package com.example.vocabulary.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vocabulary.entities.Vocabulary;
import com.example.vocabulary.repositories.VocabularyRepository;

@Service
public class VocabularyService {

	@Autowired
	private VocabularyRepository vocabularyRepository;
	
	public List<Vocabulary> findAll() {
		return vocabularyRepository.findAll();
	}
	
	public Vocabulary save(Vocabulary vocabulary) {
		return vocabularyRepository.save(vocabulary);
	}
	
	public Vocabulary findById(Long id) {
		return vocabularyRepository.findById(id).orElse(null);
	}
	
	public void delete(Long id) {
		vocabularyRepository.deleteById(id);
	}
}
