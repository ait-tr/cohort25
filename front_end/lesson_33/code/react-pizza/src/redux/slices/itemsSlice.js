import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";

// const example = {
//     id: "0",
//     images: [
//         "https://dodopizza.azureedge.net/static/Img/Products/f035c7f46c0844069722f2bb3ee9f113_584x584.jpeg",
//         "https://kartinkin.net/uploads/posts/2021-04/1617249568_35-p-pitstsa-na-belom-fone-krasivo-45.jpg",
//         "https://i1.photo.2gis.com/images/branch/0/30258560074074452_7f68.jpg",
//         "https://aroma-avenue.ru/wp-content/uploads/2/0/e/20e000f70d8700b671b7fa82ec947967.jpeg",
//         "https://lookw.ru/1/73/1380310816-pitstsa-ch1--38.jpg",
//     ],
//     title: "Пепперони Фреш с перцем",
//     info: [
//         "пикантная пепперони",
//         "моцарелла",
//         "томаты",
//         "перец чили",
//         "томатный соус",
//     ],
//     types: [0, 1],
//     sizes: [26, 30, 40],
//     price: 803,
//     category: 4,
//     rating: 4,
//     reviews: 5,
// };

export const fetchItems = createAsyncThunk(
    "items/itemsFetchStatus",
    async (params) => {
        const { categoryId, sortingItem, searchValue, currentPage } = params;
        const res = await fetch(
            `https://6442fcd190738aa7c069c92c.mockapi.io/items?${
                categoryId > 0 ? `category=${categoryId}` : ""
            }&sortBy=${sortingItem.sortProperty}&order=${sortingItem.order}${
                searchValue ? `&search=${searchValue}` : ""
            }&page=${currentPage || 1}&limit=8`
        );
        const data = await res.json();
        return data;
    }
);

const initialState = {
    items: [],
    item: {},
    status: "loading",
    activeType: 0,
    activeSize: 0,
    typeNames: ["тонкое", "традиционное"],
};

export const itemsSlice = createSlice({
    name: "items",
    initialState,
    reducers: {
        setItems(state, actions) {
            // actions (type, payload) => type: string, payload: item[]
            state.items = actions.payload;
        },
        setItem(state, actions) {
            // actions (type, payload) => type: string, payload: item
            state.item = actions.payload;
            localStorage.setItem("item", JSON.stringify(actions.payload));
        },
        setActiveType(state, actions) {
            state.activeType = actions.payload;
        },
        setActiveSize(state, actions) {
            state.activeSize = actions.payload;
        },
    },
    extraReducers: {
        [fetchItems.pending]: (state) => {
            state.status = "loading";
            state.items = [];
        },
        [fetchItems.fulfilled]: (state, actions) => {
            state.status = "success";
            state.items = actions.payload;
        },
        [fetchItems.rejected]: (state) => {
            state.status = "error";
            state.items = [];
        },
    },
});

export const selectItemsData = (state) => state.items;

export const { setItems, setItem, setActiveType, setActiveSize } =
    itemsSlice.actions;

export default itemsSlice.reducer;
