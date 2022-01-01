package com.polls.service;

import com.polls.database.model.PollDocument;
import com.polls.database.repository.PollRepositoryMongoImpl;
import com.polls.exeptions.NotFoundException;
import com.polls.mappers.PollMapper;
import com.polls.model.dto.poll.PollDto;
import com.polls.model.dto.vote.VoteDto;
import com.polls.service.api.PollServiceApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@Transactional(readOnly = true)
@Log4j2
@RequiredArgsConstructor
public class PollServiceMongoImpl implements PollServiceApi {
    private final PollRepositoryMongoImpl pollsRepo;
    private final PollMapper mapper;

    @Override
    @Transactional
    public Mono<String> addPoll(PollDto pollDto) {
        PollDocument poll = mapper.toPollDocument(pollDto);
        return pollsRepo.save(poll)
                .doOnNext(newPoll -> log.trace("User added poll with id {} named {}",
                        () -> newPoll.getId().toString(), newPoll::getPollName))
                .map(pollDocument -> pollDocument.getId().toString());
    }

    @Override
    public Mono<PollDto> getPoll(String pollId) {
        return pollsRepo.findById(new ObjectId(pollId))
                .switchIfEmpty(Mono.error(() -> new NotFoundException(String.format("Sorry, but there is no poll with id %s!", pollId))))
                .map(mapper::toPollDto);
    }

    @Override
    @Transactional
    public Mono<PollDto> addVote(String pollId, VoteDto vote) {
        return pollsRepo.addVote(pollId, vote)
                .switchIfEmpty(Mono.error(() -> new NotFoundException(String.format("Sorry, but there is no poll with id %s!", pollId))))
                .doOnNext(poll -> log.trace("User voted for poll with id {} named {}",
                        () -> poll.getId().toString(), poll::getPollName))
                .map(mapper::toPollDto);
    }
}
