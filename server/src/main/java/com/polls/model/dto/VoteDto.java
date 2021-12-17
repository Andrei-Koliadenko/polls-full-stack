package com.polls.model.dto;

import javax.validation.constraints.NotBlank;

public class VoteDto {
	@NotBlank
	String pollId;
	@NotBlank
	String variant;

	public String getPollId() {
		return pollId;
	}

	public void setPollId(String pollId) {
		this.pollId = pollId;
	}

	public String getVariant() {
		return variant;
	}

	public void setVariant(String variant) {
		this.variant = variant;
	}

	public VoteDto(@NotBlank String pollId, @NotBlank String variant) {
		super();
		this.pollId = pollId;
		this.variant = variant;
	}

	public VoteDto() {

	}

}
