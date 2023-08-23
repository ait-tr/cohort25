setTimeout(()=>console.log("0 sec"), 0);
console.log("1");
setTimeout(()=>console.log("5 sec."),5000);
console.log("2");
setTimeout(()=>console.log('2 sec'), 2000);


let timerId=setInterval(()=>console.log('hi'),1000);
clearInterval(timerId);