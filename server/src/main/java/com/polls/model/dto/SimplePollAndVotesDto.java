package com.polls.model.dto;

import java.util.Arrays;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import com.polls.database.model.PollDocument;

public class SimplePollAndVotesDto extends PollBaseDto {
	@NotBlank
	String poll_id;
	@NotNull
	AnswerDto[] answers;
	@PositiveOrZero
	int totalVotes;

	public String getPoll_id() {
		return poll_id;
	}

	public void setPoll_id(String poll_id) {
		this.poll_id = poll_id;
	}

	public AnswerDto[] getAnswers() {
		return answers;
	}

	public void setAnswers(AnswerDto[] answers) {
		this.answers = answers;
	}

	public int getTotalVotes() {
		return totalVotes;
	}

	public void setTotalVotes(int totalVotes) {
		this.totalVotes = totalVotes;
	}

	@Override
	public String toString() {
		return "SimplePollDtoWithId [poll_id=" + poll_id + ", answers=" + Arrays.toString(answers)
				+ ", totalVotes=" + totalVotes + ", name=" + name + ", question=" + question + "]";
	}

	public SimplePollAndVotesDto(@NotBlank String name, @NotBlank String question, @NotBlank String poll_id,
			@NotNull AnswerDto[] answers, @PositiveOrZero int totalVotes) {
		super(name, question);
		this.poll_id = poll_id;
		this.answers = answers;
		this.totalVotes = totalVotes;
	}

	public SimplePollAndVotesDto() {

	}

	public SimplePollAndVotesDto(PollDocument poll) {
		super(poll.getName(), poll.getQuestion());
		this.poll_id = poll.get_id();
		this.answers = poll.getAnswers();
		this.totalVotes = poll.getTotalVotes();
	}

}
