import InitialPoll from "../models/InitialPoll";

export const SET_POLL_BEFORE_SAVE = 'set-poll-before-save';

export type ReduxActionType = {
    type: string;
    payload: any;
}

export const pollBeforeSaveAction = (payload: InitialPoll): ReduxActionType => {
    return {type: SET_POLL_BEFORE_SAVE, payload}
}