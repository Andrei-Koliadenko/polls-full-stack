package com.polls.model.dto.poll;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class QuestionDto {
    private String question;
    private List<AnswerOptionDto> answers;
    private Integer totalVotes;
}
