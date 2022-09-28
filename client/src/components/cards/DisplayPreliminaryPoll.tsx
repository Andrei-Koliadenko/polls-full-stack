import React, {FC, Fragment} from "react";
import InitialPoll from "../../models/InitialPoll";

type Props = {
    poll: InitialPoll
}

const DisplayPreliminaryPoll: FC<Props> = (props: Props) => {
    return (<Fragment>
        {JSON.stringify(props.poll)}
    </Fragment>)
}

export default DisplayPreliminaryPoll