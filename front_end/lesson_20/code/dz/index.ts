interface Student {
    firstName:string;
    lastName:string;
    isActive: boolean;
    specialization: "QA"|"FullStack";
    group : number;
    missedClasses:number;
}

let student1 ={
    firstName:"Ivan",
    lastName:"Ivanov",
    isActive:true,
    specialization: "FullStack",
    group:1,
    missedClasses:10
}
console.log(student1);

/*№2
Создать расширенный интерфейс студента с полями
additionalGroup[] 
(массив, содержащий дополнительные группы, необязательное поле)
isRepeat (студент повторяет курс или нет)
Создать несколько объектов
 */

interface StudentExtends extends Student {
     additionalGroup?: number[];
     isRepeat: boolean;
}

let student2: StudentExtends = {
 firstName: 'Alex',
 lastName:'Alexandrov',
 isActive: true,
 specialization: "QA",
 group:1,
 missedClasses:4,
 additionalGroup:[1,2],
 isRepeat:true
}
let student3: StudentExtends = {
    firstName: 'Pavel',
    lastName:'Pavlov',
    isActive: true,
    specialization: "QA",
    group:5,
    missedClasses:6,
    isRepeat:false
   }
console.log(student2);
console.log(student3);


/*Создать функцию, которая принимает массив чисел и возвращает их сумму.  */
function sumNumber(arr:number[]):number

/*
{
    let sum = 0;
    for(let i=0;i<arr.length;i++){
        sum = sum + arr[i];
    }
   return sum;
}
*/
/*
{

let sum = 0;
        arr.forEach((num) => {
            sum += num;
        });
        return sum;
}
*/
{
    return arr.reduce((previousValue, currentValue) => previousValue + currentValue, 0);
}

let res =sumNumber([1,2,3,4,5]);
console.log(res);

/*Создать функцию, которая принимает тип платежа (“cash”, “card”, “bank transfer”)
 и возвращает код 100, 200, 300 соответственно.
 */

 function typeOfPayment (code:string) :number {
    switch(code){
        case "cash": return 100;
        case "card": return 200;
        case "bank transfer": return 300;
    }
    throw new Error(""); 
 }
console.log(typeOfPayment("cash"));

/* №5*
Создать тип данных описывающий функцию,
которая принимает аргумент-массив чисел 
и возвращает число. Создать переменную этого типа, 
в которую положить функцию написанную на шаге 3. Вызвать ее.
*/
type SumNumberFunction = (arr: number[]) => number;
let arraySum: SumNumberFunction = sumNumber;
let arr = [1, 2, 3];
res = arraySum(arr);
console.log(res); 


type func5Type = (array: number[]) => number;

let func5: func5Type = (arr) => sumNumber(arr);

let func6: func5Type = sumNumber;

console.log(func5([1,2,3,4]));