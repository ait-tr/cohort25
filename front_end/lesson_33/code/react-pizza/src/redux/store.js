import { configureStore } from "@reduxjs/toolkit";

import cartReducer from './slices/cartSlice';
import searchReducer from './slices/searchSlice';
import filterReducer from './slices/filterSlice';
import itemsReducer from './slices/itemsSlice';

export default configureStore({
    reducer: {
        filter: filterReducer,
        search: searchReducer,
        items: itemsReducer,
        cart: cartReducer
    }
})