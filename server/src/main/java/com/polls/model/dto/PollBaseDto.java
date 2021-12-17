package com.polls.model.dto;

import javax.validation.constraints.NotBlank;

public abstract class PollBaseDto {
	@NotBlank
	String name;
	@NotBlank
	String question;

	public PollBaseDto(@NotBlank String name, @NotBlank String question) {
		this.name = name;
		this.question = question;
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

	public PollBaseDto() {

	}

	public String getName() {
		return name;
	}

}
