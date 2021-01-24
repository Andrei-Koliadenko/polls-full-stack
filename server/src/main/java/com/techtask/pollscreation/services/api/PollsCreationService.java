package com.techtask.pollscreation.services.api;

import com.techtask.pollscreation.dto.SimplePollDto;
import com.techtask.pollscreation.dto.SimplePollAndVotesDto;
import com.techtask.pollscreation.dto.VoteDto;

public interface PollsCreationService {	
	String addPoll(SimplePollDto pollDto);
	
	SimplePollAndVotesDto addVote(VoteDto vote);
}
