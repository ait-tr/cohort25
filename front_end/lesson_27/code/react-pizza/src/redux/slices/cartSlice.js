import { createSlice } from "@reduxjs/toolkit";

const initialState = {
    totalPrice: 0,
    items: []
};

/*
    Пример одного товара:

    const item = {
        id: 1,
        count: 5,
        price: 10
    }
*/ 

export const cartSlice = createSlice({
    name: 'cart',
    initialState,
    reducers: {
        addToCart(state, action) {
            const findItem = state.items.find(
                // action (type, payload) => type: string, payload: item (объект)
                item => item.id === action.payload.id
            );
            if (findItem) {
                // Здесь мы изменим кол-во (так как товар в корзине уже есть)
                findItem.count++;
            } else {
                // Здесь мы добавим новую позицию в корзину
                state.items.push({
                    ...action.payload,
                    count: 1
                })
            }
            state.totalPrice = state.items.reduce(
                (acc, item) => acc + item.price * item.count,
                0
            )
        },
        incrementCount(state, action) {
            const findItem = state.items.find(
                // action (type, payload) => type: string, payload: string (id)
                item => item.id === action.payload
            );
            if (findItem) {
                findItem.count++;
            }
            state.totalPrice = state.items.reduce(
                (acc, item) => acc + item.price * item.count,
                0
            )
        },
        decrementCount(state, action) {
            const findItem = state.items.find(
                // action (type, payload) => type: string, payload: string (id)
                item => item.id === action.payload
            );
            if (findItem && findItem.count > 1) {
                findItem.count--;
            }
            state.totalPrice = state.items.reduce(
                (acc, item) => acc + item.price * item.count,
                0
            )
        },
        removeAllItems(state) {
            state.items = [];
            state.totalPrice = 0;
        },
        removeItem(state, action) {
            // action (type, payload) => type: string, payload: string (id)
            state.items = state.items.filter(item => item.id !== action.payload);
        }
    }
});

export const selectCart = (state) => state.cart;

export const {
    addToCart,
    incrementCount,
    decrementCount,
    removeAllItems,
    removeItem
} = cartSlice.actions

export default cartSlice.reducer;