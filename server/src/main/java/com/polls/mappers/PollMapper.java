package com.polls.mappers;

import com.polls.database.model.AnswerOptionDocument;
import com.polls.database.model.PollDocument;
import com.polls.database.model.QuestionDocument;
import com.polls.model.dto.poll.AnswerOptionDto;
import com.polls.model.dto.poll.PollDto;
import com.polls.model.dto.poll.QuestionDto;
import org.bson.types.ObjectId;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = MapperUtils.class, config = MapperConfiguration.class, imports = ObjectId.class)
public interface PollMapper {
    PollDocument toPollDocument(PollDto poll);

    PollDto toPollDto(PollDocument poll);

    @Mapping(source = "answers", target = "totalVotes")
    QuestionDto toQuestionDto(QuestionDocument questionDocument);

    @Mapping(target = "id", expression = "java(new ObjectId())")
    @Mapping(target = "votesCount", constant = "0")
    AnswerOptionDocument toAnswerOptionDocument(AnswerOptionDto answerOption);


}
