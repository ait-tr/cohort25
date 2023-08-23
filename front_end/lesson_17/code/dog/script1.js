const pic = document.getElementById('imgDog');
const btn = document.getElementById('btnNextPic');

const url = "https://dog.ceo/api/breeds/image/random";
btn.addEventListener('click', loadPic);

//async await

async function loadPic(){
     let response =  await fetch(url);
    if (response.ok){


    }

    //console.log(response);
    let result= await response.json();
    //console.log(result);
    return result;    
}

async function demo(){
    return 1;
}

console.log(demo());


/*
let res = await loadPic();
console.log(res);
*/