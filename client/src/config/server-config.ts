import PollsServiceRestImpl from "../services/PollsServiceObservableRestImpl";

const SERVER_URL = "http://localhost:8080/poll"
export const servicePolls = new PollsServiceRestImpl(SERVER_URL);