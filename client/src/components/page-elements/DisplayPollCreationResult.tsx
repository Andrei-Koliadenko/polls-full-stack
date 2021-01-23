import React, {FC, Fragment} from "react";
import {Typography} from "@material-ui/core";

type Props = {
    message: string,
}

const DisplayPollCreationResult: FC<Props> = (props: Props) => {
    return <Fragment>
        <Typography variant="subtitle1" component={'span'}>
            {props.message}
        </Typography>
    </Fragment>
}
export default DisplayPollCreationResult