/*
setTimeout(()=>console.log("0 sec"), 0);
console.log("1");
setTimeout(()=>console.log("5 sec."),5000);
console.log("2");
setTimeout(()=>console.log('2 sec'), 2000);


//let timerId= setInterval(()=>console.log('hi'),1000);
//setTimeout(()=>clearInterval(timerId), 7000);


let timer = setTimeout(
    function f(){
        console.log('HI');
        timer = setTimeout(f,1000);
    }
,1000);
setTimeout(()=>clearInterval(timer), 7000);
*/

///////   Create Promise

let serverAvailable=true;
let serverTimeOut = 7_000;
let data={};

function getDataFromFakeServer(){
    let fakeUser={firstName:"Jack", lastName:"Johnson", age:20};
    console.log('server start......');

    let executorFunction = (resolve, reject) => {
        if(serverAvailable){
            setTimeout(()=>{resolve(fakeUser)},serverTimeOut);
        } else {
            setTimeout(()=>{reject("error!!! ")}, serverTimeOut);     
        }
    };

return new Promise(executorFunction);
}



///  Promise Handler
let resultPromise = getDataFromFakeServer();
console.log(data);

resultPromise.then(
            (rez)=> {data=rez; console.log(data)},
            (err)=> {console.log("server not available"); console.log(err)}
        );

console.log(" .......  ")




























