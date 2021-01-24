import React, {ChangeEvent, FC} from "react";
import {createStyles, makeStyles, TextField, Theme} from "@material-ui/core";
import Grid from "@material-ui/core/Grid";
import SimplePoll from "../../models/SimplePoll";
import AddBoxIcon from '@material-ui/icons/AddBox';
import Button from "@material-ui/core/Button";
import Typography from "@material-ui/core/Typography";

type Props = {
    pollForm: SimplePoll;
    setPollForm: (poll: SimplePoll) => void;
    error: boolean,
    pollQuestionErrorMessage: string,
    notEnoughAnswersMessage: string
}

const useStyles = makeStyles((theme: Theme) =>
    createStyles({
        margin: {
            margin: theme.spacing(1),
        },
    }),
);

const PollQuestionAnswers: FC<Props> = (props: Props) => {
    const classes = useStyles();

    function getPollAnswers(): JSX.Element[] {
        return props.pollForm.variants.map((item: string, index: number, answers: string[]) => {
            const incrementedIndex = index + 1;

            return <TextField
                id="poll_answer"
                label={"Answer " + incrementedIndex}
                value={props.pollForm.variants[index]}
                variant="standard"
                required
                fullWidth
                className={classes.margin}
                inputProps={{style: {fontSize: 20}}}
                InputLabelProps={{style: {fontSize: 20}}}
                FormHelperTextProps={{style: {fontSize: 15}}}
                onChange={(event: ChangeEvent<HTMLInputElement>) => {
                    answers[index] = event.target.value;
                    props.setPollForm({
                        name: props.pollForm.name,
                        question: props.pollForm.question,
                        variants: answers,
                    })
                }}
            />

        })
    }

    const handleAddAnotherAnswer = () => {
        const answers: string[] = props.pollForm.variants;
        answers.push("");
        props.setPollForm({
            name: props.pollForm.name,
            question: props.pollForm.question,
            variants: answers,
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
                    className={classes.margin}
                    inputProps={{style: {fontSize: 20}}}
                    InputLabelProps={{style: {fontSize: 20}}}
                    FormHelperTextProps={{style: {fontSize: 15}}}
                    onChange={(event: ChangeEvent<HTMLInputElement>) => props.setPollForm({
                        name: props.pollForm.name,
                        question: event.target.value,
                        variants: props.pollForm.variants,
                    })}
                />
                <br/>
                {props.notEnoughAnswersMessage &&
                <Typography component={'span'} variant={'subtitle1'} color="error" className={classes.margin}>
                    {props.notEnoughAnswersMessage}
                </Typography>}
                {getPollAnswers()}
                <Button
                    variant="contained"
                    color="primary"
                    className={classes.margin}
                    startIcon={<AddBoxIcon/>}
                    onClick={handleAddAnotherAnswer}
                >
                    Add another answer
                </Button>
            </Grid>
        </Grid>
    )
}
export default PollQuestionAnswers