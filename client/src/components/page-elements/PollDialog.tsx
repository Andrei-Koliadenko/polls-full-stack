import React, {FC, useEffect, useState} from "react";
import DialogTitle from "@material-ui/core/DialogTitle";
import DialogContent from "@material-ui/core/DialogContent";
import DialogActions from "@material-ui/core/DialogActions";
import Button from "@material-ui/core/Button";
import Dialog from "@material-ui/core/Dialog";
import Slide from "@material-ui/core/Slide";
import {TransitionProps} from "@material-ui/core/transitions";
import useTheme from "@material-ui/core/styles/useTheme";
import useMediaQuery from "@material-ui/core/useMediaQuery";
import Step from "@material-ui/core/Step";
import StepLabel from "@material-ui/core/StepLabel";
import Stepper from "@material-ui/core/Stepper";
import {createStyles, makeStyles, Theme} from "@material-ui/core/styles";
import PollName from "../forms/PollName";
import SimplePoll from "../../models/SimplePoll";
import PollQuestionAnswers from "../forms/PollQuestionAnswers";
import PollCard from "./PollCard";
import {servicePolls} from "../../config/server-config";
import DisplayPollCreationResult from "./DisplayPollCreationResult";
import CircularProgress from "@material-ui/core/CircularProgress";

const Transition = React.forwardRef(function Transition(
    props: TransitionProps & { children?: React.ReactElement<any, any> },
    ref: React.Ref<unknown>,
) {
    return <Slide direction="up" ref={ref} {...props} />;
});

type Props = {
    openLoginFormDialog: boolean,
    setOpenLoginFormDialog: (openLoginFormDialog: boolean) => void;
}

const useStyles = makeStyles((theme: Theme) =>
    createStyles({
        button: {
            marginRight: theme.spacing(1),
        },
        instructions: {
            marginTop: theme.spacing(1),
            marginBottom: theme.spacing(1),
        },
    }),
);

function getSteps() {
    return ['Input name of the poll', 'Input question and answer options', 'Create a poll'];
}

const PollDialog: FC<Props> = (props: Props) => {
    const theme = useTheme();
    const fullScreen = useMediaQuery(theme.breakpoints.down('sm'));
    const [loading, setLoading] = useState<boolean>(false);
    const classes = useStyles();
    const [activeStep, setActiveStep] = useState<number>(0);
    const [pollNameErrorMessage, setPollNameErrorMessage] = useState<string>("");
    const [pollNameError, setPollNameError] = useState<boolean>(false);
    const [pollQuestionAnswersErrorMessage, setPollQuestionAnswersErrorMessage] = useState<string>("");
    const [notEnoughAnswersMessage, setNotEnoughAnswersMessage] = useState<string>("");
    const [pollQuestionAnswersError, setPollQuestionAnswersError] = useState<boolean>(false);
    const [pollCreationResultMessage, setPollCreationResultMessage] = useState<string>("");
    const steps = getSteps();

    const [pollForm, setPollForm] = useState<SimplePoll>({
        name: "",
        question: "",
        variants: ["", ""]
    })
    const filteredAnswers: string[] = pollForm.variants.filter(Boolean);

    function getStepContent(step: number) {
        switch (step) {
            case 0:
                return <PollName pollForm={pollForm} setPollForm={setPollForm} error={pollNameError}
                                 pollNameErrorMessage={pollNameErrorMessage}/>;
            case 1:
                return <PollQuestionAnswers pollForm={pollForm}
                                            setPollForm={setPollForm}
                                            error={pollQuestionAnswersError}
                                            pollQuestionErrorMessage={pollQuestionAnswersErrorMessage}
                                            notEnoughAnswersMessage={notEnoughAnswersMessage}/>;
            case 2:
                return <PollCard poll={pollForm}/>
            case 3:
                return <DisplayPollCreationResult message={pollCreationResultMessage}/>
            default:
                return 'Unknown step';
        }
    }

    useEffect(() => {
        if (pollForm.name.length !== 0) {
            setPollNameErrorMessage("")
            setPollNameError(false)
        }
        if (pollForm.question.length !== 0) {
            setPollQuestionAnswersErrorMessage("")
            setPollQuestionAnswersError(false)
        }
        if (filteredAnswers.length >= 2) {
            setNotEnoughAnswersMessage("");
        }
    }, [pollForm.name.length, pollForm.question.length, filteredAnswers.length])

    const handleNext = async () => {
        switch (activeStep) {
            case 0:
                if (pollForm.name.length === 0) {
                    setPollNameErrorMessage("⚠ Name is a required field")
                    setPollNameError(true)
                    return;
                }
                break;
            case 1:
                if (pollForm.question.length === 0) {
                    setPollQuestionAnswersErrorMessage("⚠ Question is a required field")
                    setPollQuestionAnswersError(true)
                    return;
                }
               // const filteredAnswers: string[] = pollForm.answers.filter(Boolean);
                if (filteredAnswers.length < 2) {
                    setNotEnoughAnswersMessage("At least 2 answers are required!")
                    return;
                }
                setPollForm({
                    name: pollForm.name,
                    question: pollForm.question,
                    variants: filteredAnswers,
                })
                break;
            case 2:
                try {
                    setLoading(true);
                    const response = await servicePolls.createSimplePoll(pollForm);
                    console.log(response.data);
                    const pollId: string = response.data;
                    const pollUrl: string = "localhost:3000/poll/" + pollId;
                    const message: string = "Your link to the poll: " + pollUrl;
                    setPollCreationResultMessage(message);
                    break;
                } catch (error) {
                    setPollCreationResultMessage("Error! Poll wasn't created. Please try again later");
                    break;
                    // eslint-disable-next-line no-unreachable
                } finally {
                    setPollForm({
                        name: "",
                        question: "",
                        variants: ["", ""],
                    })
                    setLoading(false);
                }
            default:
                return 'Unknown step';
        }
        setActiveStep((prevActiveStep) => prevActiveStep + 1);
    };

    const handleBack = () => {
        setActiveStep((prevActiveStep) => prevActiveStep - 1);
    };

    const handleReset = () => {
        setActiveStep(0);
    };


    return (<React.Fragment>
        <Dialog open={props.openLoginFormDialog} onClose={() => props.setOpenLoginFormDialog(false)}
                fullScreen={fullScreen} aria-labelledby="poll-dialog-title" TransitionComponent={Transition}>
            <DialogTitle id="poll-dialog-title">Create poll</DialogTitle>
            <DialogContent>
                <Stepper activeStep={activeStep} alternativeLabel>
                    {steps.map((label) => (
                        <Step key={label}>
                            <StepLabel>{label}</StepLabel>
                        </Step>
                    ))}
                </Stepper>
                {getStepContent(activeStep)}
            </DialogContent>
            <DialogActions>
                {activeStep === steps.length ? (
                    <div>
                        <Button onClick={handleReset} className={classes.button}>Create new poll</Button>
                        <Button onClick={() => props.setOpenLoginFormDialog(false)}
                                className={classes.button} variant="contained" color="primary">
                            Finish
                        </Button>
                    </div>
                ) : (
                    <div>
                        <div>
                            <Button
                                disabled={activeStep === 0}
                                onClick={handleBack}
                                className={classes.button}
                            >
                                Back
                            </Button>
                            <Button variant="contained" color="primary" onClick={handleNext}>
                                {loading && <CircularProgress size={24} style={{marginRight: 10, marginLeft: 0}}/>}
                                {activeStep === steps.length - 1 ? 'Create' : 'Next'}
                            </Button>
                        </div>
                    </div>
                )}
            </DialogActions>
        </Dialog>
    </React.Fragment>)
}
export default PollDialog