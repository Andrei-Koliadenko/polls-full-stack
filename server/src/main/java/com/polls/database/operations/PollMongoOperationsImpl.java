package com.polls.database.operations;

import com.polls.database.model.PollDocument;
import com.polls.model.dto.vote.VoteDto;

public class PollMongoOperationsImpl implements PollMongoOperations{
    @Override
    public PollDocument addVote(String pollId, VoteDto vote) {
        return null;
    }
}
