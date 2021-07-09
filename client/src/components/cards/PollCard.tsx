import React, {FC, Fragment} from "react";
import SimplePoll from "../../models/SimplePoll";

type Props = {
    poll: SimplePoll
}

const PollCard: FC<Props> = (props: Props) => {
    return (<Fragment>
        {JSON.stringify(props.poll)}
    </Fragment>)
}

export default PollCard