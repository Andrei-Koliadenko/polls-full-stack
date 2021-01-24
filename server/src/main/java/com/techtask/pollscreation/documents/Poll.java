package com.techtask.pollscreation.documents;

import java.util.Arrays;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.techtask.pollscreation.dto.Answer;
import com.techtask.pollscreation.dto.SimplePollDto;

@Document(collection = "polls")
public class Poll {
	@Id
	String _id;
	@NotBlank
	String name;
	@NotBlank
	String question;
	@NotNull
	Answer[] answers;
	@PositiveOrZero
	int totalVotes;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

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

	public Answer[] getAnswers() {
		return answers;
	}

	public void setAnswers(Answer[] answers) {
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
		return "Poll [_id=" + _id + ", name=" + name + ", question=" + question + ", answers="
				+ Arrays.toString(answers) + ", totalVotes=" + totalVotes + "]";
	}

	public Poll(String _id, @NotBlank String name, @NotBlank String question, @NotNull Answer[] answers,
			@PositiveOrZero int totalVotes) {
		super();
		this._id = _id;
		this.name = name;
		this.question = question;
		this.answers = answers;
		this.totalVotes = totalVotes;
	}

	public Poll() {

	}

	public Poll(SimplePollDto poll) {
		this._id = new ObjectId().toHexString();
		this.name = poll.getName();
		this.question = poll.getQuestion();
		String[] variants = poll.getVariants();
		this.answers = new Answer[variants.length];
		for (int i = 0; i < variants.length; i++) {
			Answer answer = new Answer(variants[i], 0);
			this.answers[i] = answer;
		}
		this.totalVotes = 0;
	}

}
