package com.techtask.pollscreation.services.api;

import com.techtask.pollscreation.dto.SimplePollDto;
import com.techtask.pollscreation.dto.SimplePollDtoWithId;
import com.techtask.pollscreation.dto.VoteDto;

public interface PollsCreationService {	
	String addPoll(SimplePollDto pollDto);
	
	SimplePollDtoWithId addVote(VoteDto vote);
}
