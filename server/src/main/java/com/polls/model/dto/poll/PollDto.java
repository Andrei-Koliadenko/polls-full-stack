package com.polls.model.dto.poll;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PollDto {
    private String id;
    private String pollName;
    private QuestionDto question;
}
