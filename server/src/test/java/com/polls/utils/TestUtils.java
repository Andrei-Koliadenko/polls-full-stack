package com.polls.utils;

import com.polls.database.model.AnswerOptionDocument;
import com.polls.database.model.PollDocument;
import com.polls.database.model.QuestionDocument;
import com.polls.model.dto.poll.AnswerOptionDto;
import com.polls.model.dto.poll.PollDto;
import com.polls.model.dto.poll.QuestionDto;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.SplittableRandom;

public class TestUtils {
    private static final SplittableRandom splittableRandom = new SplittableRandom();

    public static PollDto getRandomPollDto() {
        int suffix = splittableRandom.nextInt(Integer.MAX_VALUE/2);

        AnswerOptionDto firstOption = AnswerOptionDto
                .builder()
                .id(ObjectId.get().toString())
                .answer("first option" + suffix)
                .votesCount(suffix)
                .build();
        AnswerOptionDto secondOption = AnswerOptionDto
                .builder()
                .id(ObjectId.get().toString())
                .answer("second option" + suffix)
                .votesCount(suffix + 1)
                .build();

        QuestionDto question = QuestionDto
                .builder()
                .question("testQuestion" + suffix)
                .answers(List.of(firstOption, secondOption))
                .build();

        return PollDto.builder()
                .id(ObjectId.get().toString())
                .pollName("testPoll" + suffix)
                .question(question)
                .build();
    }

    public static PollDocument getRandomPollDocument() {
        int suffix = splittableRandom.nextInt(Integer.MAX_VALUE/2);

        AnswerOptionDocument firstOption = AnswerOptionDocument
                .builder()
                .id(ObjectId.get())
                .answer("first option" + suffix)
                .votesCount(suffix)
                .build();
        AnswerOptionDocument secondOption = AnswerOptionDocument
                .builder()
                .id(ObjectId.get())
                .answer("second option" + suffix)
                .votesCount(suffix + 1)
                .build();

        QuestionDocument question = QuestionDocument
                .builder()
                .question("testQuestion" + suffix)
                .answers(List.of(firstOption, secondOption))
                .build();

        return PollDocument.builder()
                .id(ObjectId.get())
                .pollName("testPoll" + suffix)
                .question(question)
                .build();
    }
}
