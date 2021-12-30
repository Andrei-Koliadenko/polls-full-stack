package com.polls.mappers;

import com.polls.database.model.PollDocument;
import com.polls.model.dto.poll.PollDto;
import com.polls.utils.TestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PollMapperTest {
    @Autowired
    private PollMapper mapper;

    @Test
    public void mapToPollDocumentWithInvalidId_ShouldBeException() {
        PollDto pollDto = TestUtils.getRandomPollDto();
        pollDto.setId("invalidId");

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> mapper.toPollDocument(pollDto));

        String expectedMessage = "invalid hexadecimal representation of an ObjectId";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void mapToPollDocument_ShouldBeMapped() {
        PollDto pollDto = TestUtils.getRandomPollDto();
        PollDocument pollDocument = mapper.toPollDocument(pollDto);

        assertAll("All fields should be mapped",
                () -> assertNull(pollDocument.getId()),

                () -> assertEquals(pollDto.getPollName(), pollDocument.getPollName()),

                () -> assertEquals(pollDto.getQuestion().getQuestion(), pollDocument.getQuestion().getQuestion()),

                () -> assertNotNull(pollDocument.getQuestion().getAnswers().get(0).getId()),

                () -> assertEquals(pollDto.getQuestion().getAnswers().get(0).getAnswer(),
                        pollDocument.getQuestion().getAnswers().get(0).getAnswer()),

                () -> assertEquals(0, pollDocument.getQuestion().getAnswers().get(0).getVotesCount()),

                () -> assertNotNull(pollDocument.getQuestion().getAnswers().get(1).getId()),

                () -> assertEquals(pollDto.getQuestion().getAnswers().get(1).getAnswer(),
                        pollDocument.getQuestion().getAnswers().get(1).getAnswer()),

                () -> assertEquals(0, pollDocument.getQuestion().getAnswers().get(1).getVotesCount())
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
