package com.techtask.pollscreation.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.techtask.pollscreation.documents.Poll;

public interface PollsCreationRepository extends MongoRepository<Poll, String> {

}
