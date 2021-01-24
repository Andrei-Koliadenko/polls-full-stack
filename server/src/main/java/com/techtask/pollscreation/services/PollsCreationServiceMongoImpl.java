package com.techtask.pollscreation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techtask.pollscreation.documents.Poll;
import com.techtask.pollscreation.dto.Answer;
import com.techtask.pollscreation.dto.SimplePollDto;
import com.techtask.pollscreation.dto.SimplePollDtoWithId;
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
	public SimplePollDtoWithId addVote(VoteDto vote) {
		Poll poll = pollsRepo.findById(vote.getPollId()).orElse(null);
		String variant = vote.getVariant();
		if (poll != null) {
			Answer[] answers = poll.getAnswers();
			for (int i = 0; i < answers.length; i++) {
				if (answers[i].getAnswer() == variant) {
					int addedVoteCount = answers[i].getVotesCount();
					answers[i].setVotesCount(++addedVoteCount);
					break;
				}
			}
			poll.setAnswers(answers);
		} else {
			throw new NotFoundException(String.format("Sorry, but there is no poll with id %s!", vote.getPollId()));
		}
		return null;
	}

//	@Override
//	@Transactional
//	public PollDtoWithId addPoll(PollDto pollDto) {
//		PollDtoWithId pollDtowithId = new PollDtoWithId(pollDto);
//		Poll poll = new Poll(pollDtowithId);
//		pollsRepo.save(poll);
//		return pollDtowithId;
//	}

//	@Override
//	public List<PollDtoWithId> getPolls() {
//		List<Poll> polls = pollsRepo.findAll();
//		if (polls.size() > 0) {
//			return polls.stream().map(this::toPollDtoWithId).collect(Collectors.toList());
//		} else {
//			throw new NotFoundException(String.format("Sorry, but there are no polls yet!"));
//		}
//	}

//	@Override
//	public PollDtoWithId getPoll(String id) {
//		Optional<Poll> poll = pollsRepo.findById(id);
//		if (poll.isPresent()) {
//			return toPollDtoWithId(poll.get());
//		} else {
//			throw new NotFoundException(String.format("Sorry, but poll with id %s doesn't exist", id));
//		}
//	}

//	private PollDtoWithId toPollDtoWithId(Poll poll) {
//		return new PollDtoWithId(poll.get_id(), poll.getPollName(), poll.getPollQuestionsVariants());
//	}

}
