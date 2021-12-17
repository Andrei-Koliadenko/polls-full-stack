package com.polls.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SimplePollDto extends PollBaseDto {
	@NotNull
	String[] variants;

	public String[] getVariants() {
		return variants;
	}

	public void setVariants(String[] variants) {
		this.variants = variants;
	}

	public SimplePollDto(@NotBlank String name, @NotBlank String question, @NotNull String[] variants) {
		super(name, question);
		this.variants = variants;
	}

	public SimplePollDto() {
		super();
	}
}
