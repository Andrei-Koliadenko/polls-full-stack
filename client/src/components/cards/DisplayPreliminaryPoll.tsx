import React, {FC, Fragment} from "react";
import InitialPoll from "../../models/InitialPoll";
import AddBoxIcon from "@material-ui/icons/AddBox";
import Button from "@material-ui/core/Button";
import {createStyles, makeStyles, Theme} from "@material-ui/core";
import {PATH_PREVIEW_POLL} from "../../config/links";

type Props = {
    poll: InitialPoll
}

const useStyles = makeStyles((theme: Theme) =>
    createStyles({
        margin: {
            margin: theme.spacing(1),
        },
    }),
);

const DisplayPreliminaryPoll: FC<Props> = (props: Props) => {
    const classes = useStyles();

    const handleDisplayDemoPoll = () => {
        window.open(PATH_PREVIEW_POLL, "_blank")?.focus();
    }

    return (<Fragment>
        <Button
            variant="contained"
            color="primary"
            className={classes.margin}
            startIcon={<AddBoxIcon/>}
            onClick={handleDisplayDemoPoll}
        >
            See preview poll
        </Button>
    </Fragment>)
}

export default DisplayPreliminaryPoll