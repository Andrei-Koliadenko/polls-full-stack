import React from 'react';
import './App.css';
import {Route, Routes} from "react-router";
import {BrowserRouter} from "react-router-dom";
import {PATH_HOME, PATH_VOTE, PATH_DEMO_POLL} from "./config/links";
import Header from "./components/page-elements/Header";
import HomePage from "./components/pages/HomePage";
import VotePage from "./components/pages/VotePage";
import DemoPollPage from "./components/pages/DemoPollPage";

function App() {
    return (<div className={'page-container'}>
            <div className={'content-wrap'}>
                <BrowserRouter>
                    <Header/>
                    <Routes>
                        <Route path={PATH_HOME} element={<HomePage/>}/>
                        <Route path={PATH_VOTE} element={<VotePage/>}/>
                        <Route path={PATH_DEMO_POLL} element={<DemoPollPage/>}/>
                    </Routes>
                </BrowserRouter>
            </div>
        </div>
    );
}

export default App;
