package com.techtask.pollscreation.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.techtask.pollscreation.dto.SimplePollDto;
import com.techtask.pollscreation.dto.SimplePollAndVotesDto;
import com.techtask.pollscreation.dto.VoteDto;
import com.techtask.pollscreation.services.api.PollsCreationService;

import static com.techtask.pollscreation.services.api.PollsCreationApiConstants.*;

@RestController
@CrossOrigin
@Validated
@Valid
public class PollsCreationRestController {
	@Autowired
	PollsCreationService service;

	@PostMapping(ADD_POLL)
	String addPoll(@RequestBody @Valid SimplePollDto pollDto) {
		return service.addPoll(pollDto);
	}

	@PostMapping(ADD_VOTE)
	SimplePollAndVotesDto vote(@RequestBody @Valid VoteDto voteDto) {
		return service.addVote(voteDto);
	}

	@GetMapping(GET_POLL)
	SimplePollAndVotesDto getPoll(@RequestParam(name = "id") String id) {
		return service.getPoll(id);
	}
}
