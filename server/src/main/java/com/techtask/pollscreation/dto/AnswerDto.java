package com.techtask.pollscreation.dto;

public class AnswerDto {
	String answer;
	int votesCount;

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getVotesCount() {
		return votesCount;
	}

	public void setVotesCount(int votesCount) {
		this.votesCount = votesCount;
	}

	public AnswerDto(String answer, int votesCount) {
		this.answer = answer;
		this.votesCount = votesCount;
	}

	public AnswerDto() {

	}
	
	

}
