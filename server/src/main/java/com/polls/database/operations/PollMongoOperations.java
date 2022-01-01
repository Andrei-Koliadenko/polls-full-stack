package com.polls.database.operations;

import com.polls.database.model.PollDocument;
import com.polls.model.dto.vote.VoteDto;
import reactor.core.publisher.Mono;

public interface PollMongoOperations {
    Mono<PollDocument> addVote(String pollId, VoteDto vote);
}
