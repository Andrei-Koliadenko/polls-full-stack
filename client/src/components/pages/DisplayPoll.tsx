import React, {FC, useState} from "react";
import {servicePolls} from "../../config/server-config";
import {Observable} from "rxjs";
import SimplePollAndVotes from "../../models/SimplePollAndVotes";
import {useParams} from "react-router";
import VoteCard from "../Cards/VoteCard";

interface RouteParams {
    id: string
}

const DisplayPoll: FC = () => {
    const {id} = useParams<RouteParams>();

    const response: Observable<SimplePollAndVotes> = servicePolls.getSimplePoll(id);
    const [poll, setPoll] = useState<SimplePollAndVotes>();

    response.subscribe(data => setPoll(data), error => console.log(error));
    return <React.Fragment>
        <VoteCard poll={poll}/>
    </React.Fragment>
}
export default DisplayPoll