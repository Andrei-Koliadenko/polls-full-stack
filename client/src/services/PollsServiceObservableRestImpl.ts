import {Axios} from "axios-observable";
import PollsServiceObservable from "./PollsServiceObservable";
import {Observable, throwError} from "rxjs";
import {catchError, map} from "rxjs/operators";
import {AxiosError} from "axios";
import ErrorTypes from "../models/ErrorTypes";
import PollDto from "../models/PollDto";
import InitialPoll from "../models/InitialPoll";

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

    createPoll(poll: InitialPoll): Observable<string> {
        return Axios.post<string>(this.url + '/create', poll)
            .pipe(
                map(response => response.data),
                catchError(err => {
                    return throwError(handleError(err));
                })
            );
    }

    getPoll(pollId: string | undefined): Observable<PollDto> {
        return Axios.get<PollDto>(this.url + "/" + pollId)
            .pipe(
                map(response => response.data),
                catchError(err => {
                    return throwError(handleError(err));
                })
            );
    }
}