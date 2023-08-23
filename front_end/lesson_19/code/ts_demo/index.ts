let s="hello";
let s2:string;

s2="yyeye";

console.log(s);

s= "hello hello";


let a:number = 10;
let b:boolean = true;

// b="false" // Error "false" is a string

// UNION TYPE

let q1:string|number|null = "10sss";
console.log(q1);
q1=18;
console.log(q1);
q1=null;

console.log(typeof(null));

let q3:1|2|3;
q3=3;   // ok!
//q3=4;  // error!!!!

let q4:"true"|true|"false"|false|null;
q4= false;
console.log(q4);
q4= "false";
console.log(q4);


let amount:20|50|100|500;
let code:"ok"|"error"|"try again";


// CREATE TYPES
//type FirstName = "jack"|"oleg"|"john";
type FirstName = string;
let q5:FirstName= "jack";


type TimeUnit1 = "hour"|"minute"|"second";
type TimeUnit2 = "day"|"month"|"year";
type TimeUnit3 = TimeUnit1|TimeUnit2|"week";

let q6:TimeUnit3; //     "hour"|"minute"|"second"|"day"|"month"|"year"|"week"
let q7:TimeUnit1|TimeUnit2|"week" = "week";   
q7="hour";

let q8:TimeUnit3 ="week";
let q9= "week";  q9="jhjhjhhds";// string

let arr1:TimeUnit1[]=["hour","hour","minute"];
arr1[0]="second";

let arr2: (TimeUnit1|TimeUnit2)[] = [];
arr2.push("day");
console.log(arr2);

let arr3:(string|number)[]=[1,2,3,"one"];

let arr4:(TimeUnit1|boolean|null)[]=["hour", null, true,true];
console.log(arr4);



type Car ={
    model:string;
    engine:"benzin"|"disel"|"electro";
    power: number;
    equipment?:string;
};

let car1:Car={
    model: "ford",
    engine: "benzin",
    power: 189
};
console.log(car1);

interface Auto{
    model:string;
    engine:"benzin"|"disel"|"electro";
    power: number;
    equipment?:string;   
}

let car2:Auto = {
    model: "bmw",
    engine: "electro",
    power: 380,
    equipment:"sport",
};

console.log(car2);

//car2=car1;
//console.log(car1);


// extens interface
interface AutoExtends extends Auto{
    color:string;
    price: number;
}

let car3:AutoExtends ={
    color: "black",
    price: 10_000,
    model: "lada",
    engine: "benzin",
    power: 79
} 


// Function
function getLen(str:string):number{
    return str.length;
}
console.log(getLen("help me with TS"));

function getCharFromIndex(str:string, index:number):string|null {
    if(index<0||index>str.length) return null;
    return str.charAt(index);
}

let func:(a:number, b: number)=>number;

func = (a,b)=>a-b;
console.log(func(6,10));

func = (a,b)=>a+b;
console.log(func(6,10));

func = function(x,y){return x-y+10};
console.log(func(6,10));

type BiConsumer = (a:string, b:string)=> void;

let f1:BiConsumer = (a,b)=>{
    if(a.length>b.length){
        console.log(a);
    } else {
        console.log(b);
        
    }
}


f1("qwe","print qwerty");
f1("print qwe","qwehh");

function temp(func:BiConsumer, s1:string, s2:string):void{
    if(s1!="hello" && s2!="hello"){
        func(s1,s2);
    }
}

temp(f1,"yui", "yyyell");
temp(f1,"hello","uuue");
temp((a,b)=> console.log(a), "rtyyye","kkjjd");



/*

Создать интерфейс Student со следующими полями
ffirstName
lastName
isActive
specialization   (QA или FullStack)
group
missedСlasses
 
Создать несколько объектов-студентов


*/