package com.polls.database.operations;

import com.polls.database.model.PollDocument;
import com.polls.model.dto.vote.VoteDto;

public interface PollMongoOperations {
    PollDocument addVote(String pollId, VoteDto vote);
}
