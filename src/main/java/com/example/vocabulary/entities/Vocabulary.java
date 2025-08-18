package com.example.vocabulary.entities;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_vocabulary")
public class Vocabulary implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String wordOrPhrase;
	private String translation;
	private String example;
	private String referenceLink;
	
	public Vocabulary() {}

	public Vocabulary(Long id, String wordOrPhrase, String translation, String example, String referenceLink) {
		this.id = id;
		this.wordOrPhrase = wordOrPhrase;
		this.translation = translation;
		this.example = example;
		this.referenceLink = referenceLink;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWordOrPhrase() {
		return wordOrPhrase;
	}

	public void setWordOrPhrase(String wordOrPhrase) {
		this.wordOrPhrase = wordOrPhrase;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}

	public String getExample() {
		return example;
	}

	public void setExample(String example) {
		this.example = example;
	}

	public String getReferenceLink() {
		return referenceLink;
	}

	public void setReferenceLink(String referenceLink) {
		this.referenceLink = referenceLink;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vocabulary other = (Vocabulary) obj;
		return Objects.equals(id, other.id);
	}

}
