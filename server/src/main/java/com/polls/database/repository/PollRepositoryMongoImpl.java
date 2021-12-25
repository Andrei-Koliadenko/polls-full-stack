package com.polls.database.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.polls.database.model.PollDocument;

public interface PollRepositoryMongoImpl extends MongoRepository<PollDocument, ObjectId> {
}
