import React, {FC, Fragment} from "react";
import InitialPoll from "../../models/InitialPoll";
import DemoPollPage from "../pages/DemoPollPage";
import AddBoxIcon from "@material-ui/icons/AddBox";
import Button from "@material-ui/core/Button";
import {createStyles, makeStyles, Theme} from "@material-ui/core";
import InitialQuestion from "../../models/InitialQuestion";

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

    const handleAddAnotherQuestion = () => {

    }

    return (<Fragment>
        <DemoPollPage poll={props.poll}/>
        <br/>
        <Button
            variant="contained"
            color="primary"
            className={classes.margin}
            startIcon={<AddBoxIcon/>}
            onClick={handleAddAnotherQuestion}
        >
            Add another question
        </Button>
    </Fragment>)
}

export default DisplayPreliminaryPoll