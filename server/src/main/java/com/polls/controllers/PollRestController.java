package com.polls.controllers;

import com.polls.controllers.api.PollApiPath;
import com.polls.model.dto.poll.PollDto;
import com.polls.model.dto.vote.VoteDto;
import com.polls.service.api.PollServiceApi;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("poll")
@CrossOrigin
@Validated
@Valid
@RequiredArgsConstructor
public class PollRestController {
    private final PollServiceApi service;

    @PostMapping(PollApiPath.ADD_POLL)
    String addPoll(@RequestBody @Valid PollDto poll) {
        return service.addPoll(poll);
    }

    @PostMapping(PollApiPath.ADD_VOTE)
    PollDto vote(@RequestBody @Valid VoteDto vote, @PathVariable(name = "pollId") String pollId) {
        return service.addVote(pollId, vote);
    }

    @GetMapping(PollApiPath.GET_POLL)
    PollDto getPoll(@PathVariable(name = "id") String id) {
        return service.getPoll(id);
    }
}
