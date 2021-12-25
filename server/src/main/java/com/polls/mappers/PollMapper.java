package com.polls.mappers;

import com.polls.database.model.PollDocument;
import com.polls.model.dto.poll.PollDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = MapperUtils.class, config = MapperConfiguration.class)
public interface PollMapper {
    PollDocument toPollDocument(PollDto poll);

    @Mapping(target = "question.totalVotes", source = "question.answers")
    PollDto toPollDto(PollDocument poll);
}
