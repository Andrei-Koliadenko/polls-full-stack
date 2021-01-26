import React, {FC, useEffect, useState} from "react";
import {servicePolls} from "../../config/server-config";
import {Observable} from "rxjs";
import SimplePollAndVotes from "../../models/SimplePollAndVotes";
import {useParams} from "react-router";
import VoteCard from "../Cards/VoteCard";

interface RouteParams {
    id: string
}

const DisplayPoll: FC = () => {
    const [poll, setPoll] = useState<SimplePollAndVotes>();
    const {id} = useParams<RouteParams>();

    useEffect(()=> {
        const response: Observable<SimplePollAndVotes> = servicePolls.getSimplePoll(id);
        response.subscribe(data => {
            setPoll(data)
            console.log(data)
        }, error => console.log(error));
    },[])

    return <React.Fragment>
        <VoteCard poll={poll}/>
    </React.Fragment>
}
export default DisplayPoll