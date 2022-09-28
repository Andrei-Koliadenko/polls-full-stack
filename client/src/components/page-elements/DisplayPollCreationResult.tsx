import React, {FC, Fragment} from "react";
import PollCreationResult from "../../models/PollCreationResult";

type Props = {
    pollCreationResult: PollCreationResult,
}

const DisplayPollCreationResult: FC<Props> = (props: Props) => {
    return <Fragment>
        <a href={props.pollCreationResult.pollLink}> {props.pollCreationResult.message} </a>
    </Fragment>
}

export default DisplayPollCreationResult