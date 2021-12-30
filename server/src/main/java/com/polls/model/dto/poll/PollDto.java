package com.polls.model.dto.poll;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Null;

@Data
@Builder
public class PollDto {
    @Null
    private String id;
    private String pollName;
    private QuestionDto question;
}
