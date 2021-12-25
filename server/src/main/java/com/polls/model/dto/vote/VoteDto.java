package com.polls.model.dto.vote;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class VoteDto {
    private String question;
    private String answerId;
}
