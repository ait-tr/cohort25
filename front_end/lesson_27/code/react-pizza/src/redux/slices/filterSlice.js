import { createSlice } from "@reduxjs/toolkit"

const initialState = {
    categoryId: 0,
    categoryNames: [
        "Все",
        "Мясные",
        "Вегетарианские",
        "Гриль",
        "Острые",
        "Закрытые"
    ],
    categoryName: 'Все',
    sortingItems: {
        name: "популярности",
        sortProperty: "rating",
        order: "desc"
    },
    currentPage: 1
}

export const filterSlice = createSlice({
    name: 'filter',
    initialState,
    reducers: {
        onClickCategory(state, action) {
            // action (type, payload) => type: string, payload: string (id)
            state.categoryId = action.payload;
            state.categoryName = state.categoryNames[state.categoryId];
        },
        onClickSort(state, action) {
            // action (type, payload) => type: string, payload: sortingItems (объект)
            state.sortingItems = action.payload;
        },
        setCurrentPage(state, action) {
            // action (type, payload) => type: string, payload: number (номер страницы)
            state.currentPage = action.payload
        }
    }
})

export const selectFilter = (state) => state.filter;

export const {
    onClickCategory,
    onClickSort,
    setCurrentPage
} = filterSlice.actions

export default filterSlice.reducer;