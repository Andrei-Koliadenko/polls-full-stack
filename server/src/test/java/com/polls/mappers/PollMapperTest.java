package com.polls.mappers;

import com.polls.database.model.PollDocument;
import com.polls.model.dto.poll.PollDto;
import com.polls.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PollMapperTest {
    @Autowired
    private PollMapper mapper;

    @Test
    public void mapToPollDocument_ShouldBeMapped() {
        PollDto pollDto = TestUtils.getRandomPollDto();
        PollDocument pollDocument = mapper.toPollDocument(pollDto);

        assertAll("All fields should be mapped",
                () -> assertEquals(pollDto.getId(), pollDocument.getId().toString()),

                () -> assertEquals(pollDto.getPollName(), pollDocument.getPollName()),

                () -> assertEquals(pollDto.getQuestion().getQuestion(), pollDocument.getQuestion().getQuestion()),

                () -> assertEquals(pollDto.getQuestion().getAnswers().get(0).getId(),
                        pollDocument.getQuestion().getAnswers().get(0).getId().toString()),

                () -> assertEquals(pollDto.getQuestion().getAnswers().get(0).getAnswer(),
                        pollDocument.getQuestion().getAnswers().get(0).getAnswer()),

                () -> assertEquals(pollDto.getQuestion().getAnswers().get(0).getVotesCount(),
                        pollDocument.getQuestion().getAnswers().get(0).getVotesCount()),

                () -> assertEquals(pollDto.getQuestion().getAnswers().get(1).getId(),
                        pollDocument.getQuestion().getAnswers().get(1).getId().toString()),

                () -> assertEquals(pollDto.getQuestion().getAnswers().get(1).getAnswer(),
                        pollDocument.getQuestion().getAnswers().get(1).getAnswer()),

                () -> assertEquals(pollDto.getQuestion().getAnswers().get(1).getVotesCount(),
                        pollDocument.getQuestion().getAnswers().get(1).getVotesCount())
        );
    }

    @Test
    public void mapToPollDto_ShouldBeMapped() {
        PollDocument pollDocument = TestUtils.getRandomPollDocument();
        PollDto pollDto = mapper.toPollDto(pollDocument);

        assertAll("All fields should be mapped",
                () -> assertEquals(pollDocument.getId().toString(), pollDto.getId()),

                () -> assertEquals(pollDocument.getPollName(), pollDto.getPollName()),

                () -> assertEquals(pollDocument.getQuestion().getQuestion(), pollDto.getQuestion().getQuestion()),

                () -> assertEquals(pollDocument.getQuestion().getAnswers().get(0).getId().toString(),
                        pollDto.getQuestion().getAnswers().get(0).getId()),

                () -> assertEquals(pollDocument.getQuestion().getAnswers().get(0).getAnswer(),
                        pollDto.getQuestion().getAnswers().get(0).getAnswer()),

                () -> assertEquals(pollDocument.getQuestion().getAnswers().get(0).getVotesCount(),
                        pollDto.getQuestion().getAnswers().get(0).getVotesCount()),

                () -> assertEquals(pollDocument.getQuestion().getAnswers().get(1).getId().toString(),
                        pollDto.getQuestion().getAnswers().get(1).getId()),

                () -> assertEquals(pollDocument.getQuestion().getAnswers().get(1).getAnswer(),
                        pollDto.getQuestion().getAnswers().get(1).getAnswer()),

                () -> assertEquals(pollDocument.getQuestion().getAnswers().get(1).getVotesCount(),
                        pollDto.getQuestion().getAnswers().get(1).getVotesCount()),

                () -> assertEquals(pollDocument.getQuestion().getAnswers().get(0).getVotesCount() +
                        pollDocument.getQuestion().getAnswers().get(1).getVotesCount(), pollDto.getQuestion().getTotalVotes())
        );
    }
}
