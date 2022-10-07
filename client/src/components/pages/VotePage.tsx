import React, {FC, useEffect, useState} from "react";
import {servicePolls} from "../../config/server-config";
import {EMPTY, Subscription} from "rxjs";
import {useParams} from "react-router";
import VoteCard from "../cards/VoteCard";
import PollDto from "../../models/PollDto";

interface RouteParams {
    [key: string]: string | undefined,
}

const VotePage: FC = () => {
    const [poll, setPoll] = useState<PollDto>();
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

            function getData(): void {
                servicePolls.getPoll(id)
                    .pipe(data => {
                        data.subscribe(poll => setPoll(poll));
                        return EMPTY;
                    })
            }

            return () => {
                if (subscription && !subscription.closed) {
                    subscription.unsubscribe();
                }
                if (intervalId) {
                    clearInterval(intervalId)
                }
            }
        },
        [id]
    )

    return <React.Fragment>
        <VoteCard poll={poll}/>
    </React.Fragment>
}
export default VotePage