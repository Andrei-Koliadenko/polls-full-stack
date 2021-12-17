import SimplePoll from "../models/SimplePoll";
import {Observable} from "rxjs";
import SimplePollAndVotes from "../models/SimplePollAndVotes";

export default interface PollsServiceObservable {
    createSimplePoll(poll: SimplePoll): Promise<any>;

    getSimplePoll(pollId: string | undefined): Observable<SimplePollAndVotes>;
}