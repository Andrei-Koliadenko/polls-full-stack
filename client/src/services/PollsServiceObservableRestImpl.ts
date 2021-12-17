import {Axios} from "axios-observable";
import PollsServiceObservable from "./PollsServiceObservable";
import Poll from "../models/Poll";
import SimplePoll from "../models/SimplePoll";
import {Observable, throwError} from "rxjs";
import SimplePollAndVotes from "../models/SimplePollAndVotes";
import {catchError, map} from "rxjs/operators";
import {AxiosError} from "axios";
import ErrorTypes from "../models/ErrorTypes";

function handleError(err: AxiosError): ErrorTypes {
    if (err.response) {
        if (err.response.status === 401 || err.response.status === 403) {
            return ErrorTypes.AUTH_ERROR;
        } else {
            return ErrorTypes.SERVER_ERROR;
        }
    } else {
        return ErrorTypes.NETWORK_ERROR;
    }
}

export default class PollsServiceObservableRestImpl implements PollsServiceObservable {
    constructor(private url: string) {

    }

    createSimplePoll(poll: SimplePoll): Promise<any> {
        return Axios.post<Poll>(this.url + '/create', poll).toPromise();
    }

    getSimplePoll(pollId: string | undefined): Observable<SimplePollAndVotes> {
        return Axios.get<SimplePollAndVotes>(this.url, {
            params: {
                id: pollId
            }
        })
            .pipe(
                map(response => response.data),
                catchError(err => {
                    return throwError(handleError(err));
                })
            );
    }
}