package com.techtask.pollscreation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techtask.pollscreation.documents.Poll;
import com.techtask.pollscreation.dto.AnswerDto;
import com.techtask.pollscreation.dto.SimplePollDto;
import com.techtask.pollscreation.dto.SimplePollAndVotesDto;
import com.techtask.pollscreation.dto.VoteDto;
import com.techtask.pollscreation.exeptions.NotFoundException;
import com.techtask.pollscreation.repo.PollsCreationRepository;
import com.techtask.pollscreation.services.api.PollsCreationService;

@Service
@Transactional(readOnly = true)
public class PollsCreationServiceMongoImpl implements PollsCreationService {
	@Autowired
	PollsCreationRepository pollsRepo;

	@Override
	@Transactional
	public String addPoll(SimplePollDto pollDto) {
		Poll poll = new Poll(pollDto);
		pollsRepo.save(poll);
		return poll.get_id();
	}

	@Override
	@Transactional
	public SimplePollAndVotesDto addVote(VoteDto vote) {
		Poll poll = pollsRepo.findById(vote.getPollId()).orElse(null);
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
		Poll poll = pollsRepo.findById(pollId).orElse(null);
		if (poll != null) {
			return new SimplePollAndVotesDto(poll);
		} else {
			throw new NotFoundException(String.format("Sorry, but there is no poll with id %s!", pollId));
		}
	}

}
