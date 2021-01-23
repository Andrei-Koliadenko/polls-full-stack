import React, {FC} from "react";
import AppBar from "@material-ui/core/AppBar";
import Toolbar from "@material-ui/core/Toolbar";

const Header: FC = () => {
    return <div style={{paddingTop: 80}}>
        <AppBar>
            <Toolbar>
                <h2>Create your own poll!</h2>
            </Toolbar>
        </AppBar>
    </div>
}
export default Header