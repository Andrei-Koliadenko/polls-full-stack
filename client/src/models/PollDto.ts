import QuestionDto from "./QuestionDto";

interface PollDto {
    id: string;
    pollName: string;
    question: QuestionDto;
}

export default PollDto