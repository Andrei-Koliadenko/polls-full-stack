package com.polls.database.operations;

import com.polls.database.model.PollDocument;
import com.polls.model.dto.vote.VoteDto;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class PollMongoOperationsImpl implements PollMongoOperations {
    private final ReactiveMongoTemplate template;

    @Override
    public Mono<PollDocument> addVote(String pollId, VoteDto vote) {
        Query query = new Query(Criteria
                .where("id").is(new ObjectId(pollId))
                .and("question.question").is(vote.getQuestion()));
        Update update= new Update();
        update.inc("question.answers.$[answer].votesCount");
        update.filterArray("answer._id", new ObjectId(vote.getAnswerId()));
        FindAndModifyOptions options = new FindAndModifyOptions();
        options.returnNew(true);
        return template.findAndModify(query, update, options, PollDocument.class);
    }
}
