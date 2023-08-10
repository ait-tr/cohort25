import { createSlice, PayloadAction } from '@reduxjs/toolkit';

interface BoardState {
    squares: Array<string | null>;
    xIsNext: boolean;
}

const initialState: BoardState = {
    squares: Array(9).fill(null),
    xIsNext: true
}

const boardSlice = createSlice({
    name: 'board',
    initialState,
    reducers: {
        handleClick: (state, actions: PayloadAction<number>) => {
            // Для кнопки Reset
            if (actions.payload === -1) {
                state.squares = Array(9).fill(null);
                state.xIsNext = true;
                return;
            }
            // Глубока копия массива
            const squares = [...state.squares];
            // Кейс при наличии итогового результата и при клике на занятую клетку
            if (calculateWinner(squares) || squares[actions.payload]) {
                return;
            }
            // Реализуем ход, в зависимости от очереди хода
            squares[actions.payload] = state.xIsNext ? 'X' : 'O';
            // Сохраняем копию в глобальное состояние
            state.squares = squares;
            // Меняем очерёдность хода
            state.xIsNext = !state.xIsNext;
        }
    }
})

export function calculateWinner(squares: Array<string | null>): string | null {
    const lines = [
        [0, 1, 2],
        [3, 4, 5],
        [6, 7, 8],
        [0, 3, 6],
        [1, 4, 7],
        [2, 5, 8],
        [0, 4, 8],
        [2, 4, 6],
    ];

    // for (let i = 0; i < lines.length - 1; i++) {
    //     const [a, b, c] = lines[i];
    //     if (squares[a] && squares[a] === squares[b] && squares[a] === squares[c]) {
    //         return squares[a];
    //     }
    // }

    for (const [a, b, c] of lines) {
        if (squares[a] && squares[a] === squares[b] && squares[a] === squares[c]) {
            return squares[a];
        }
    }

    if (squares.every(square => square !== null)) {
        return 'Draw';
    }

    return null;
}

export const { handleClick } = boardSlice.actions;

export const selectSquares = ((state: { board: BoardState }) => state.board.squares);

export default boardSlice.reducer;