package com.techtask.pollscreation.dto;

import java.util.Arrays;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SimplePollDto {
	@NotBlank
	String name;
	@NotBlank
	String question;
	@NotNull
	String[] variants;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String[] getVariants() {
		return variants;
	}

	public void setVariants(String[] variants) {
		this.variants = variants;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		result = prime * result + Arrays.hashCode(variants);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimplePollDto other = (SimplePollDto) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		if (!Arrays.equals(variants, other.variants))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SimplePollDto [name=" + name + ", question=" + question + ", variants=" + Arrays.toString(variants)
				+ "]";
	}

	public SimplePollDto(@NotBlank String name, @NotBlank String question, String[] variants) {
		super();
		this.name = name;
		this.question = question;
		this.variants = variants;
	}

	public SimplePollDto() {

	}

}
