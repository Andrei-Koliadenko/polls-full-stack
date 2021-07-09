import React, {FC, Fragment} from "react";
import SimplePollAndVotes from "../../models/SimplePollAndVotes";

type Props = {
    poll: SimplePollAndVotes | undefined
}

const VoteCard: FC<Props> = (props: Props) => {
    return (<Fragment>
        {JSON.stringify(props.poll)}
    </Fragment>)
}

export default VoteCard