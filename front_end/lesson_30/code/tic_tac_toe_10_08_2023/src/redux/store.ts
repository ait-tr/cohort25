import { configureStore } from "@reduxjs/toolkit";
import boardReducer from './gameSlice';

export const store = configureStore({
    reducer: {
        board: boardReducer
    }
})