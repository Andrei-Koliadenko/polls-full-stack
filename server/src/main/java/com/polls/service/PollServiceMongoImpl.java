package com.polls.service;

import com.polls.database.model.PollDocument;
import com.polls.database.repository.PollRepositoryMongoImpl;
import com.polls.exeptions.NotFoundException;
import com.polls.mappers.PollMapper;
import com.polls.model.dto.poll.PollDto;
import com.polls.model.dto.vote.VoteDto;
import com.polls.service.api.PollServiceApi;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PollServiceMongoImpl implements PollServiceApi {
	private final PollRepositoryMongoImpl pollsRepo;
	private final PollMapper mapper;

	@Override
	@Transactional
	public String addPoll(PollDto pollDto) {
		PollDocument poll = mapper.toPollDocument(pollDto);
		return pollsRepo.save(poll).getId().toString();
	}

	@Override
	public PollDto getPoll(String pollId) {
		PollDocument poll = pollsRepo.findById(new ObjectId(pollId)).orElse(null);
		if (poll != null) {
			return mapper.toPollDto(poll);
		} else {
			throw new NotFoundException(String.format("Sorry, but there is no poll with id %s!", pollId));
		}
	}

	@Override
	@Transactional
	public PollDto addVote(String pollId, VoteDto vote) {
		return mapper.toPollDto(pollsRepo.addVote(pollId, vote));
	}
}
