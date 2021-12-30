package com.polls.mappers;

import com.polls.database.model.AnswerOptionDocument;
import com.polls.database.model.PollDocument;
import com.polls.model.dto.poll.AnswerOptionDto;
import com.polls.model.dto.poll.PollDto;
import org.bson.types.ObjectId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = MapperUtils.class, config = MapperConfiguration.class, imports = ObjectId.class)
public interface PollMapper {
    PollDocument toPollDocument(PollDto poll);

    @Mapping(source = "question.answers", target = "question.totalVotes")
    PollDto toPollDto(PollDocument poll);

    @Mapping(target = "id", expression = "java(new ObjectId())")
    @Mapping(target = "votesCount", constant = "0")
    AnswerOptionDocument toAnswerOptionDocument(AnswerOptionDto answerOption);


}
