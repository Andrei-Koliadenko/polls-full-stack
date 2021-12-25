package com.polls.database.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class QuestionDocument {
    private String question;
    private List<AnswerOptionDocument> answers;
}
