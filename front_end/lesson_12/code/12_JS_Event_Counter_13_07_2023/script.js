const decrement10 = document.getElementById('decrement10');
const decrement = document.getElementById('decrement');
const increment = document.getElementById('increment');
const increment10 = document.getElementById('increment10');
const countSpan = document.getElementById('count');
const reset = document.getElementById('reset');

// Создали счётчик
let count = 0;

// 
function updateCount(val) {
    // 1. Складывает счетчик и переданное значение
    count += val;

    // 2. Даём новый текстовый контент для countSpan
    countSpan.textContent = count;
}

// addEventListener ожидает имя события и функцию-описание самого действия
decrement10.addEventListener('click', () => {
    updateCount(-10)
})
decrement.addEventListener('click', () => {
    updateCount(-1)
})
increment.addEventListener('click', () => {
    updateCount(1)
})
increment10.addEventListener('click', () => {
    updateCount(10)
})
reset.addEventListener('click', () => {
    updateCount(-count)
})
