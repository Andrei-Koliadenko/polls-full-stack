import SimplePoll from "../models/SimplePoll";

export default interface PollsServiceObservable {
    createSimplePoll(poll: SimplePoll): Promise<any>;
}