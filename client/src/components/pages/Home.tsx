import React, {FC, useState} from "react";
import Card from "@material-ui/core/Card";
import CardContent from "@material-ui/core/CardContent";
import Typography from "@material-ui/core/Typography";
import CardActions from "@material-ui/core/CardActions";
import Button from "@material-ui/core/Button";
import PollDialog from "../page-elements/PollDialog";

const Home: FC = () => {
    const [openCreatePollDialog, setCreatePollDialog] = useState<boolean>(false);

    return (
        <div style={{
            position: 'absolute', left: '50%', top: '50%',
            transform: 'translate(-50%, -50%)'
        }}>
            <Card>
                <CardContent>
                    <Typography variant={"h5"}>
                        This application allows you to create a poll and share it
                    </Typography>
                </CardContent>
                <CardActions>
                    <Button size="large" variant="contained" color="primary" fullWidth
                            onClick={() => setCreatePollDialog(true)}>
                        Create poll
                    </Button>
                </CardActions>
            </Card>
            <br/>
            {openCreatePollDialog &&
            <PollDialog openLoginFormDialog={openCreatePollDialog} setOpenLoginFormDialog={setCreatePollDialog}/>}
        </div>)
}
export default Home