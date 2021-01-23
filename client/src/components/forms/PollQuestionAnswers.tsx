import React, {ChangeEvent, FC} from "react";
import {TextField} from "@material-ui/core";
import Grid from "@material-ui/core/Grid";
import SimplePoll from "../../models/SimplePoll";

type Props = {
    pollForm: SimplePoll;
    setPollForm: (poll: SimplePoll) => void;
    error: boolean,
    pollQuestionErrorMessage: string,
}

const PollQuestionAnswers: FC<Props> = (props: Props) => {
    function getPollAnswers(): JSX.Element[] {
        return props.pollForm.answers.map((item: string, index: number, answers: string[]) => {
            const incrementedIndex = index + 1;

            return <TextField
                id="poll_answer"
                label={"Answer " + incrementedIndex}
                value={props.pollForm.answers[index]}
                variant="standard"
                required
                fullWidth
                onChange={(event: ChangeEvent<HTMLInputElement>) => {
                    answers[index] = event.target.value;
                    props.setPollForm({
                        name: props.pollForm.name,
                        question: props.pollForm.question,
                        answers: answers,
                    })
                }}
                inputProps={{style: {fontSize: 25}}}
                InputLabelProps={{style: {fontSize: 20}}}
                FormHelperTextProps={{style: {fontSize: 15}}}
            />

        })
    }

    return (
        <Grid container spacing={2}>
            <Grid item xs={12}>
                <TextField
                    id="poll_question"
                    label="Poll question"
                    helperText={props.pollQuestionErrorMessage}
                    error={props.error}
                    value={props.pollForm.question}
                    variant="outlined"
                    required
                    fullWidth
                    onChange={(event: ChangeEvent<HTMLInputElement>) => props.setPollForm({
                        name: props.pollForm.name,
                        question: event.target.value,
                        answers: props.pollForm.answers,
                    })}
                    inputProps={{style: {fontSize: 25}}}
                    InputLabelProps={{style: {fontSize: 20}}}
                    FormHelperTextProps={{style: {fontSize: 15}}}
                />
                <br/><br/>
                {getPollAnswers()}
            </Grid>
        </Grid>
    )
}
export default PollQuestionAnswers