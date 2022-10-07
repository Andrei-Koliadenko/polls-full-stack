import {createStore} from "redux";
import {productListReducer} from "./reducers";

export const store = createStore(productListReducer, (window as any).__REDUX_DEVTOOLS_EXTENSION__ &&
    (window as any).__REDUX_DEVTOOLS_EXTENSION__());