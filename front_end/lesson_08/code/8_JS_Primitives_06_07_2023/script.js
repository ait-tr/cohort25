// System.out.print()
console.log('Hello world!');

// undefined - переменная создана, но ей не присвоено значение

// var - переменная. Отличается от let областью видимости. (deprecated - не желательно к использованию)
// let - переменная. Можно переприсваивать значение
// const - константа. Нельзя переприсваивать значение

let x;
console.log(x);

x = 7;
console.log(x);

// В отличии от Java JavaScript является НЕ строго-типизированным языком программирования.
// Это значит, что любой переменной может быть присвоено значение любого типа данных
x = 'bye';
console.log(x);

// 1. начинается с маленькой буквы;
// 2. CamelCase
// numberOfPassport - пример наименования переменной

const pi = 3.1415926;
// pi = 3.14; пример ошибки с использованием ключевого слова const

let y = x;
console.log(y);

// Конкатенация (операция склеивания). Результатом конкатенации всегда будет строка,
// полученная в результате "склеивания" "слагаемых"
console.log('pi = ' + pi);

const exp = pi;
// `` (косые кавычки) дают возможность прямо внутри строки обращаться к любым переменным,
// которые у нас есть 
console.log(`exp = ${exp} or ${pi}`);

x = true;
console.log(x);

x = null;
console.log(x);

let res = 7 % 2 // остаток от деления
console.log(res);

// Неявное приведение типов:

// 567 => '567'    ----     '' + 567
res = 'true ' + 5;
console.log(res);

res = true + 5; // true = 1, false = 0
console.log(res);

// = - присваивание
// == - сравнение (нестрогое) - сравниваем значение, не учитывая типы данных
// === - сравнение (строгое) - сравниваем значение, учитывая типы данных

x = '2' == 2;
console.log(x);

x = '2' === 2;
console.log(x);

res = +true; // Number(true);
res = 5 + ''; // String(5);
res = +'5'; // Number('5');

switch (res) {
    case 5:
        console.log(`number: ${res}`);
        break;
    case '5':
        console.log(`string: ${res}`);
        break;
    default:
        console.log('Not a 5');
}

let age = 17;
let vol = age > 17 ? 42 : 1.5;

// метод чисел toFixed оставляет то кол-во знаков после запятой, которое мы передадим в этот метод
console.log(pi.toFixed(2));

++age; // вначале мы прибавляем к переменной единицу, а потом используем значение переменной
age++; // вначале мы используем значение переменной, а потом прибавляем к переменной единицу

x = 10;
// console.log(x++);
//     10 +  12 + 13 + 13 = 22
res = x++ + ++x;
console.log(res);

res = sumDigits(1234);
console.log(`res = ${res}`);  // 10

function sumDigits(x) {
    // TODO
}

res = luckyNumber(123871); // 1 + 2 + 3 == 8 + 7 + 1
console.log(res ? 'Lucky' : 'Unlucky');  // 

function luckyNumber(x) {
    // TODO
}

// ADVANCED(*****)
function banana() {
    let a = 'a';
    let b = 'b';
    // TODO
    // 'b', 'a' => 'banana'
    // * Подсказка: конкатенация, математические действия 
}