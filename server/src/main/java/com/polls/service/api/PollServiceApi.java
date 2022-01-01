package com.polls.service.api;

import com.polls.model.dto.poll.PollDto;
import com.polls.model.dto.vote.VoteDto;
import reactor.core.publisher.Mono;

public interface PollServiceApi {
    Mono<String> addPoll(PollDto poll);

    Mono<PollDto> getPoll(String pollId);

    Mono<PollDto> addVote(String pollId, VoteDto vote);
}
