package com.example.vocabulary.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vocabulary.entities.Vocabulary;
import com.example.vocabulary.services.VocabularyService;

@RestController
@RequestMapping(value = "/api/vocabulary")
public class VocabularyController {

	@Autowired
	private VocabularyService vocabularyService;
	
	@GetMapping
	public ResponseEntity<List<Vocabulary>> findAll() {
		return ResponseEntity.ok(vocabularyService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Vocabulary vocabulary) {
		Vocabulary saved = vocabularyService.save(vocabulary);
		return ResponseEntity.ok("Word/Phrase saved successfully with ID: " + saved.getId());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Vocabulary vocabulary = vocabularyService.findById(id);
		if(vocabulary == null) {
			return ResponseEntity.status(404).body("Word/Phrase not found with ID: " + id);
		}
		return ResponseEntity.ok(vocabulary);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Vocabulary vocabulary) {
		Vocabulary existing = vocabularyService.findById(id);
		if(existing == null) {
			return ResponseEntity.status(404).body("Word/Phrase not found with ID: " + id);
		}
		
		existing.setWordOrPhrase(vocabulary.getWordOrPhrase());
		existing.setTranslation(vocabulary.getTranslation());
		existing.setExample(vocabulary.getExample());
		existing.setReferenceLink(vocabulary.getReferenceLink());
		
		Vocabulary updated = vocabularyService.save(existing);
		
		return ResponseEntity.ok("Word/Phrase updated successfully with ID: " + updated.getId());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Vocabulary deleted = vocabularyService.findById(id);
		if(deleted == null) {
			return ResponseEntity.status(404).body("Word/Phrase not found with ID: " + id);
		}
		vocabularyService.delete(id);
		return ResponseEntity.ok("Word/Phrase deleted with successfully with ID: " + id);
	}
}
