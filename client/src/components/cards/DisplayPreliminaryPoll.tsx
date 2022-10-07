import React, {FC, Fragment} from "react";
import InitialPoll from "../../models/InitialPoll";
import DemoPollPage from "../pages/DemoPollPage";

type Props = {
    poll: InitialPoll
}

const DisplayPreliminaryPoll: FC<Props> = (props: Props) => {
    return <DemoPollPage poll={props.poll}/>
}

export default DisplayPreliminaryPoll