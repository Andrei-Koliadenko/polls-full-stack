package com.polls.controllers;

import com.polls.controllers.api.PollApiPath;
import com.polls.model.dto.poll.PollDto;
import com.polls.model.dto.vote.VoteDto;
import com.polls.service.api.PollServiceApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Controller
@RequestMapping("poll")
@CrossOrigin
@Validated
@Valid
@RequiredArgsConstructor
public class PollReactiveController {
    private final PollServiceApi service;

    @PostMapping(PollApiPath.ADD_POLL)
    @ResponseBody
    Mono<String> addPoll(@RequestBody @Valid PollDto poll) {
        return service.addPoll(poll);
    }

    @PostMapping(PollApiPath.ADD_VOTE)
    @ResponseBody
    Mono<PollDto> vote(@RequestBody @Valid VoteDto vote, @PathVariable String pollId) {
        return service.addVote(pollId, vote);
    }

    @GetMapping(PollApiPath.GET_POLL)
    @ResponseBody
    Mono<PollDto> getPoll(@PathVariable(name = "id") String id) {
        return service.getPoll(id);
    }
}
