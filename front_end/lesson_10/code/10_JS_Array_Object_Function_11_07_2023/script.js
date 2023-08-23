console.log('===== Regular function =====');
console.log(multiply(3, 4));

// Регулярная функция имеет глобальную область видимости (применять функцию можно и до её объявления)
function multiply(a, b) {
    return a * b;
}

console.log(multiply(2, 5));

console.log('===== Arrow function =====');

// console.log(multiplyArrow(6, 5)); ReferenceError: нельзя вызвать стрелочную функцию до её инициализации

// Синтаксис стрелочной функции короче, особенно если результат получается в одно действие и
// помещается в одну строку (опускаются фигурные скобки и слово return)
const multiplyArrow = (a, b) => a * b;

console.log(multiplyArrow(6, 5));

console.log('===== Object =====');

// информация хранится в объекте в формате "ключ: значение"
const obj = {
    userName: 'John',
    sayHello: function() {
        console.log(this); // this = obj
        console.log(`Hello ${this.userName}`);
    }
}

obj.sayHello();

const objArrow = {
    userName: 'John',
    sayHello: () => {
        console.log(this); // this = глобальный объект Window
        console.log(`Hello ${objArrow.userName}`);
    }
}

objArrow.sayHello();

console.log('===== Object (part 2) =====');

const person = {
    firstName: 'John',
    lastName: 'Smith',
    age: 34,
    fullName: function() {
        return `${this.firstName} ${this.lastName}`
    }
}

// arr (массив ключей объекта) - это всегда массив строк, т.к. ключи всегда преобразовываются в строку
let arr = Object.keys(person);
console.log(arr);

// arr (массив значений объекта)
arr = Object.values(person);
console.log(arr);

// arr (массив с массивами: каждый массив внутри arr состоит из двух элементов: ключа и значения)
arr = Object.entries(person);
// Чтобы получить значение возраста персоны, мы обращаемся к arr, по 2 индексу получаем массив
// ['age', 34], затем по 1 индексу получаем возраст персоны
console.log(arr[2][1]);

console.log('===== Array methods (part 2) =====');

arr = ['one', 'two', 'threE', 'eight', 'tHree', 'three', 'six'];

console.log('===== indexOf =====');
let res = arr.indexOf('three');
console.log(arr); // Исходный массив не изменяется
console.log(res); // Возвращает индекс искомого элемента (или -1, если такого элемента нет)

console.log('===== includes =====');
res = arr.includes('nine');
console.log(arr); // Исходный массив не изменяется
console.log(res); // Возвращает true, если искомый элемент есть в массиве (и false, если такого элемента в массиве нет)

console.log('===== findIndex =====');
res = arr.findIndex((element, index) => index > 2 && element.toLowerCase() === 'three');
console.log(arr); // Исходный массив не изменяется
console.log(res); // Возвращает индекс первого элемента, удовлетворяющего условиям

res = arr.findIndex(predicateLength3);
console.log(res);

function predicateLength3(element, index) {
    return index >= 2 && element.length === 3;
}