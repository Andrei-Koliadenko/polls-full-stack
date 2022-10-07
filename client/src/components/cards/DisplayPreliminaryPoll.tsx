import React, {FC, Fragment} from "react";
import InitialPoll from "../../models/InitialPoll";
import DemoPollPage from "../pages/DemoPollPage";

type Props = {
    poll: InitialPoll
}

const DisplayPreliminaryPoll: FC<Props> = (props: Props) => {
    return <DemoPollPage poll={props.poll}/>
    // return (<Fragment>
    //     {JSON.stringify(props.poll)}
    // </Fragment>)
}

export default DisplayPreliminaryPoll