
import { Action } from "./types/Action";
import CounterState from "./types/CounterState";

const init:CounterState ={
    value:0
}


export default function counterReducer(
    state:CounterState = init,
    action:Action
): CounterState {
    switch (action.type){
        case "counter/plus":
            return {...state, value: state.value + action.payload}
        case "counter/minus":
            return {...state, value: state.value - action.payload}
        default:
            return state;    
    }
}