import InitialPoll from "../models/InitialPoll";
import {ReduxActionType, SET_POLL_BEFORE_SAVE} from "./actions";

export const productListReducer = (pollBeforeSave: InitialPoll = {pollName: "", questions: []},
                                   action: ReduxActionType): InitialPoll =>
    action.type === SET_POLL_BEFORE_SAVE ? action.payload : pollBeforeSave;