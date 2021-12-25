package com.polls.mappers;

import com.polls.database.model.AnswerOptionDocument;
import org.bson.types.ObjectId;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public class MapperUtils {
    public String asString(ObjectId id) {
        return id.toString();
    }

    public ObjectId asObjectId(String id) {
        return Optional.ofNullable(id)
                .map(ObjectId::new)
                .orElseGet(ObjectId::new);
    }

    public Integer toTotalVotes(List<AnswerOptionDocument> answers) {
        return answers
                .stream()
                .mapToInt(AnswerOptionDocument::getVotesCount)
                .sum();
    }
}
