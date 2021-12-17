package com.polls.services;

import com.polls.model.dto.AnswerDto;
import com.polls.model.dto.SimplePollAndVotesDto;
import com.polls.model.dto.SimplePollDto;
import com.polls.model.dto.VoteDto;
import com.polls.services.api.PollServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.polls.database.model.PollDocument;
import com.polls.exeptions.NotFoundException;
import com.polls.database.repository.PollRepositoryMongoImpl;

@Service
@Transactional(readOnly = true)
public class PollServiceMongoImpl implements PollServiceApi {
	@Autowired
	PollRepositoryMongoImpl pollsRepo;

	@Override
	@Transactional
	public String addPoll(SimplePollDto pollDto) {
		PollDocument poll = new PollDocument(pollDto);
		pollsRepo.save(poll);
		return poll.get_id();
	}

	@Override
	@Transactional
	public SimplePollAndVotesDto addVote(VoteDto vote) {
		PollDocument poll = pollsRepo.findById(vote.getPollId()).orElse(null);
		String variant = vote.getVariant();
		if (poll != null) {
			AnswerDto[] answers = poll.getAnswers();
			for (int i = 0; i < answers.length; i++) {
				if (answers[i].getAnswer().equals(variant)) {
					int addedVoteCount = answers[i].getVotesCount();
					answers[i].setVotesCount(++addedVoteCount);
					break;
				}
			}
			poll.setAnswers(answers);
			int totalVotesCount = poll.getTotalVotes();
			poll.setTotalVotes(++totalVotesCount);
			pollsRepo.save(poll);
			return new SimplePollAndVotesDto(poll);
		} else {
			throw new NotFoundException(String.format("Sorry, but there is no poll with id %s!", vote.getPollId()));
		}
	}

	@Override
	public SimplePollAndVotesDto getPoll(String pollId) {
		PollDocument poll = pollsRepo.findById(pollId).orElse(null);
		if (poll != null) {
			return new SimplePollAndVotesDto(poll);
		} else {
			throw new NotFoundException(String.format("Sorry, but there is no poll with id %s!", pollId));
		}
	}
}
