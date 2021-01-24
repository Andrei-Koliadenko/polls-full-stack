package com.techtask.pollscreation.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.bson.types.ObjectId;

public class SimplePollDtoWithId extends SimplePollDto{
	@NotBlank
	String poll_id;
	@NotNull
	Answer[] answers;
	@PositiveOrZero
	int totalVotes;

	public String getPoll_id() {
		return poll_id;
	}

	public void setPoll_id(String poll_id) {
		this.poll_id = poll_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((poll_id == null) ? 0 : poll_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimplePollDtoWithId other = (SimplePollDtoWithId) obj;
		if (poll_id == null) {
			if (other.poll_id != null)
				return false;
		} else if (!poll_id.equals(other.poll_id))
			return false;
		return true;
	}

	public SimplePollDtoWithId(@NotBlank String name, @NotBlank String question, String[] variants,
			@NotBlank String poll_id) {
		super(name, question, variants);
		this.poll_id = poll_id;
	}

	public SimplePollDtoWithId() {
		
	}

	public SimplePollDtoWithId(SimplePollDto pollDto) {
		super(pollDto.getName(), pollDto.getQuestion(), pollDto.getVariants());
		this.poll_id = new ObjectId().toHexString();
	}
	
}
