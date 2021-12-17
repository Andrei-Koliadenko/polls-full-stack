import React from 'react';
import './App.css';
import {Route, Routes} from "react-router";
import {BrowserRouter} from "react-router-dom";
import {PATH_HOME, PATH_POLL} from "./config/links";
import Header from "./components/page-elements/Header";
import Home from "./components/pages/Home";
import DisplayPoll from "./components/pages/DisplayPoll";

function App() {
    return (<div className={'page-container'}>
            <div className={'content-wrap'}>
                <BrowserRouter>
                    <Header/>
                    <Routes>
                        <Route path={PATH_HOME} element={<Home/>}/>
                        <Route path={PATH_POLL} element={<DisplayPoll/>}/>
                    </Routes>
                </BrowserRouter>
            </div>
        </div>
    );
}

export default App;
