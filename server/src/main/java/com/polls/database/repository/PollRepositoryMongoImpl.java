package com.polls.database.repository;

import com.polls.database.model.PollDocument;
import com.polls.database.operations.PollMongoOperations;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PollRepositoryMongoImpl extends ReactiveMongoRepository<PollDocument, ObjectId>, PollMongoOperations  {
}
