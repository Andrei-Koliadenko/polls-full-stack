import {Axios} from "axios-observable";
import PollsServiceObservable from "./PollsServiceObservable";
import Poll from "../models/Poll";
import SimplePoll from "../models/SimplePoll";

export default class PollsServiceObservableRestImpl implements PollsServiceObservable {
    constructor(private url: string) {

    }

    createSimplePoll(poll: SimplePoll): Promise<any> {
        return Axios.post<Poll>(this.url + '/create', poll).toPromise();
    }
}