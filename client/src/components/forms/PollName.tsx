import React, {ChangeEvent, FC} from "react";
import {TextField} from "@material-ui/core";
import Grid from "@material-ui/core/Grid";
import InitialPoll from "../../models/InitialPoll";

type Props = {
    pollForm: InitialPoll;
    setPollForm: (poll: InitialPoll) => void;
    error: boolean,
    pollNameErrorMessage: string,
}

const PollName: FC<Props> = (props: Props) => {
    return (
        <Grid container spacing={2}>
            <Grid item xs={12}>
                <TextField
                    id="poll_name"
                    label="Poll name"
                    helperText={props.pollNameErrorMessage}
                    error={props.error}
                    value={props.pollForm.pollName}
                    variant="outlined"
                    required
                    fullWidth
                    onChange={(event: ChangeEvent<HTMLInputElement>) => props.setPollForm({
                        pollName: event.target.value,
                        question: props.pollForm.question,
                    })}
                    inputProps={{style: {fontSize: 20}}}
                    InputLabelProps={{style: {fontSize: 20}}}
                    FormHelperTextProps={{style: {fontSize: 15}}}
                />
            </Grid>
        </Grid>
    )
}
export default PollName