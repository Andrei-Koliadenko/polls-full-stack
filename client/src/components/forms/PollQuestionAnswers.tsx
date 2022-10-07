import React, {ChangeEvent, FC} from "react";
import {createStyles, makeStyles, TextField, Theme} from "@material-ui/core";
import Grid from "@material-ui/core/Grid";
import AddBoxIcon from '@material-ui/icons/AddBox';
import Button from "@material-ui/core/Button";
import Typography from "@material-ui/core/Typography";
import InitialPoll from "../../models/InitialPoll";
import InitialQuestion from "../../models/InitialQuestion";

type Props = {
    pollForm: InitialPoll;
    setPollForm: (poll: InitialPoll) => void;
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
        return props.pollForm.questions[0].answers.map((item: { answer: string }, index: number, answers: { answer: string }[]) => {
            const incrementedIndex = index + 1;

            return <TextField
                id="poll_answer"
                label={"Answer " + incrementedIndex}
                value={props.pollForm.questions[0].answers[index].answer}
                variant="standard"
                required
                fullWidth
                className={classes.margin}
                inputProps={{style: {fontSize: 20}}}
                InputLabelProps={{style: {fontSize: 20}}}
                FormHelperTextProps={{style: {fontSize: 15}}}
                onChange={(event: ChangeEvent<HTMLInputElement>) => {
                    answers[index] = {answer: event.target.value};
                    props.setPollForm({
                        pollName: props.pollForm.pollName,
                        questions: props.pollForm.questions
                    })
                }}
            />

        })
    }

    const handleAddAnotherAnswer = () => {
        const question: InitialQuestion = props.pollForm.questions[0];
        question.answers.push({answer: ""});

        props.setPollForm({
            pollName: props.pollForm.pollName,
            questions: props.pollForm.questions
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
                    value={props.pollForm.questions[0].question}
                    variant="outlined"
                    required
                    fullWidth
                    className={classes.margin}
                    inputProps={{style: {fontSize: 20}}}
                    InputLabelProps={{style: {fontSize: 20}}}
                    FormHelperTextProps={{style: {fontSize: 15}}}
                    onChange={(event: ChangeEvent<HTMLInputElement>) => props.setPollForm({
                        pollName: props.pollForm.pollName,
                        questions: [{question: event.target.value, answers: props.pollForm.questions[0].answers}]
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