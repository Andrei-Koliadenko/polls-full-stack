import Answer from "./Answer";

interface SimplePollAndVotes {
    poll_id: string;
    name: string;
    question: string;
    answers: Answer[];
    totalVotes: number;
}

export default SimplePollAndVotes