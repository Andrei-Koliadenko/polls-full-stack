package com.polls.services.api;

import com.polls.model.dto.SimplePollDto;
import com.polls.model.dto.SimplePollAndVotesDto;
import com.polls.model.dto.VoteDto;

public interface PollServiceApi {
	String addPoll(SimplePollDto pollDto);

	SimplePollAndVotesDto addVote(VoteDto vote);

	SimplePollAndVotesDto getPoll(String pollId);
}
