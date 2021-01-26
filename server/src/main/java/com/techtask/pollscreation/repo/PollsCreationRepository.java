package com.techtask.pollscreation.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.techtask.pollscreation.documents.Poll;

public interface PollsCreationRepository extends MongoRepository<Poll, String> {

}

//public interface PollsCreationRepository extends ReactiveMongoRepository<Poll, String> {
//	
//}
