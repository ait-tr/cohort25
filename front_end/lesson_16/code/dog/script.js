const pic = document.getElementById('imgDog');
const btn = document.getElementById('btnNextPic');

const url = "https://dog.ceo/api/breeds/image/random";
btn.addEventListener('click', loadPic);


function loadPic(){
    fetch(url).then((response)=>{
            if(response.ok){
                return response.json();   // PROMISE
            } else {
                return Promise.reject(new Error(response.status +" " + response.statusText));
            }
        }
    ).then((res)=>{
            if(res.status == "success" ) {
                pic.src=res.message;
            } else {
                return Promise.reject(new Error("something goes wrong! Status "+ res.status));
            }
        }
    ).catch ( (qwer)=>{
           console.log(qwer);  
        }
    );

}


