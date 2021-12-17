import React, {FC, useEffect, useState} from "react";
import {servicePolls} from "../../config/server-config";
import {Subscription} from "rxjs";
import SimplePollAndVotes from "../../models/SimplePollAndVotes";
import {useParams} from "react-router";
import VoteCard from "../cards/VoteCard";

interface RouteParams {
    [key: string]: string | undefined,
}

const DisplayPoll: FC = () => {
    const [poll, setPoll] = useState<SimplePollAndVotes>();
    const {id} = useParams<RouteParams>();

    useEffect(() => {
        let intervalId: any;
        let subscription: Subscription;
        intervalId = setInterval(poller, 2000);
        getData();

        function poller() {
            if (!subscription || subscription.closed) {
                getData();
            }
        }

        function getData() {
            subscription = servicePolls.getSimplePoll(id).subscribe(data => {
                setPoll(data)
                console.log(data)
            }, error => console.log(error));
        }

        return () => {
            if (subscription && !subscription.closed) {
                subscription.unsubscribe();
            }
            if (intervalId) {
                clearInterval(intervalId)
            }
        }
    }, [id])

    return <React.Fragment>
        <VoteCard poll={poll}/>
    </React.Fragment>
}
export default DisplayPoll