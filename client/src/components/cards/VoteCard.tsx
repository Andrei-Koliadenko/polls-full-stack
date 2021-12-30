import React, {FC, Fragment} from "react";
import PollDto from "../../models/PollDto";

type Props = {
    poll: PollDto | undefined
}

const VoteCard: FC<Props> = (props: Props) => {
    return (<Fragment>
        {JSON.stringify(props.poll)}
    </Fragment>)
}

export default VoteCard