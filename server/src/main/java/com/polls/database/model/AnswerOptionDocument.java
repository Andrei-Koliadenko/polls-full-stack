package com.polls.database.model;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
@Builder
public class AnswerOptionDocument {
    @Id
    private ObjectId id;
    private String answer;
    private Integer votesCount;
}
