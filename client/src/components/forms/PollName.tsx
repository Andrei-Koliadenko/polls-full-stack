import React, {ChangeEvent, FC} from "react";
import {TextField} from "@material-ui/core";
import Grid from "@material-ui/core/Grid";
import SimplePoll from "../../models/SimplePoll";

type Props = {
    pollForm: SimplePoll;
    setPollForm: (poll: SimplePoll) => void;
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
                    value={props.pollForm.name}
                    variant="outlined"
                    required
                    fullWidth
                    onChange={(event: ChangeEvent<HTMLInputElement>) => props.setPollForm({
                        name: event.target.value,
                        question: props.pollForm.question,
                        answers: props.pollForm.answers,
                    })}
                    inputProps={{style: {fontSize: 25}}}
                    InputLabelProps={{style: {fontSize: 20}}}
                    FormHelperTextProps={{style: {fontSize: 15}}}
                />
            </Grid>
        </Grid>
    )
}
export default PollName