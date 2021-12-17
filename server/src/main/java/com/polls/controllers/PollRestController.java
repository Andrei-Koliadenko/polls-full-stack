package com.polls.controllers;

import javax.validation.Valid;

import com.polls.model.dto.SimplePollAndVotesDto;
import com.polls.model.dto.SimplePollDto;
import com.polls.model.dto.VoteDto;
import com.polls.controllers.api.PollApiPath;
import com.polls.services.api.PollServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Validated
@Valid
public class PollRestController {
	@Autowired
	PollServiceApi service;

	@PostMapping(PollApiPath.ADD_POLL)
	String addPoll(@RequestBody @Valid SimplePollDto pollDto) {
		return service.addPoll(pollDto);
	}

	@PostMapping(PollApiPath.ADD_VOTE)
	SimplePollAndVotesDto vote(@RequestBody @Valid VoteDto voteDto) {
		return service.addVote(voteDto);
	}

	@GetMapping(PollApiPath.GET_POLL)
	SimplePollAndVotesDto getPoll(@RequestParam(name = "id") String id) {
		return service.getPoll(id);
	}
}
