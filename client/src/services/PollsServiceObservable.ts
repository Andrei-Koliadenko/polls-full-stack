import {Observable} from "rxjs";
import InitialPoll from "../models/InitialPoll";
import PollDto from "../models/PollDto";

export default interface PollsServiceObservable {
    createSimplePoll(poll: InitialPoll): Promise<any>;

    getSimplePoll(pollId: string | undefined): Observable<PollDto>;
}