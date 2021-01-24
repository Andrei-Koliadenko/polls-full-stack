package com.techtask.pollscreation.dto;

import java.util.Arrays;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import com.techtask.pollscreation.documents.Poll;

public class SimplePollAndVotesDto extends PollBaseDto {
	@NotBlank
	String poll_id;
	@NotNull
	AnswerDto[] answerDtos;
	@PositiveOrZero
	int totalVotes;

	public String getPoll_id() {
		return poll_id;
	}

	public void setPoll_id(String poll_id) {
		this.poll_id = poll_id;
	}

	public AnswerDto[] getAnswerDtos() {
		return answerDtos;
	}

	public void setAnswerDtos(AnswerDto[] answerDtos) {
		this.answerDtos = answerDtos;
	}

	public int getTotalVotes() {
		return totalVotes;
	}

	public void setTotalVotes(int totalVotes) {
		this.totalVotes = totalVotes;
	}

	@Override
	public String toString() {
		return "SimplePollDtoWithId [poll_id=" + poll_id + ", answerDtos=" + Arrays.toString(answerDtos)
				+ ", totalVotes=" + totalVotes + ", name=" + name + ", question=" + question + "]";
	}

	public SimplePollAndVotesDto(@NotBlank String name, @NotBlank String question, @NotBlank String poll_id,
			@NotNull AnswerDto[] answerDtos, @PositiveOrZero int totalVotes) {
		super(name, question);
		this.poll_id = poll_id;
		this.answerDtos = answerDtos;
		this.totalVotes = totalVotes;
	}

	public SimplePollAndVotesDto() {

	}

	public SimplePollAndVotesDto(Poll poll) {
		super(poll.getName(), poll.getQuestion());
		this.poll_id = poll.get_id();
		this.answerDtos = poll.getAnswers();
		this.totalVotes = poll.getTotalVotes();
	}

}
