import QuestionDto from "./QuestionDto";

interface PollDto {
    id: string;
    pollName: string;
    questions: QuestionDto[];
}

export default PollDto