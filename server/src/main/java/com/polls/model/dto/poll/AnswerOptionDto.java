package com.polls.model.dto.poll;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnswerOptionDto {
	private String id;
	private String answer;
	private Integer votesCount;
}
