package com.polls.service.api;

import com.polls.model.dto.poll.PollDto;
import com.polls.model.dto.vote.VoteDto;

public interface PollServiceApi {
    String addPoll(PollDto poll);

    PollDto getPoll(String pollId);

    PollDto addVote(String pollId, VoteDto vote);
}
