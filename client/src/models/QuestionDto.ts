import AnswerOptionDto from "./AnswerOptionDto";

interface QuestionDto {
    question: string;
    answers: AnswerOptionDto[];
    totalVotes: number;
}

export default QuestionDto