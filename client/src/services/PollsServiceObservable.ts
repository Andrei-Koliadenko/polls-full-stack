import {Observable} from "rxjs";
import InitialPoll from "../models/InitialPoll";
import PollDto from "../models/PollDto";

export default interface PollsServiceObservable {
    createPoll(poll: InitialPoll): Observable<string>;

    getPoll(pollId: string | undefined): Observable<PollDto>;
}