const olListTodo = document.getElementById('list_todo');
const addTaskButton = document.getElementById('addTask');
const task = document.getElementById('taskInput');

const url = "https://jsonplaceholder.typicode.com/users/1/todos";

let data=[];


function loadTodo(){
    let response = fetch(url);
    response.then((response)=>{
        if(response.ok){
            return response.json();
        } else {
            throw new Error(response.status+" "+ response.statusText);
            //Promise.reject(()=>{new Error(response.status+" "+ response.statusText)})
        }
    }).then((res)=>{
        data=res;
        showData();     
     }
    ).catch((err)=> console.log(err));
    // next operators

}

function showData(){
    let resHtml = "";
    data.forEach((e,index)=>{
        let classDone = e.completed?' done':'';
        let btn = `<button index=${index} class="btn-done">${e.completed?"not done":"done"}</button>`
        let li=`<li class="li-task${classDone}">${e.title} ${btn}</li>`
        resHtml+=li;
    })

    olListTodo.innerHTML = resHtml;
    addListners();
    console.log(resHtml);

    //console.log(data);

}

function addListners(){
    let allButtons = document.getElementsByClassName('btn-done');
    Array.from(allButtons).forEach((btn)=>{
        btn.addEventListener('click',btnHandler)
    }

    )

}



function btnHandler(){
    data[this.getAttribute('index')].completed = !data[this.getAttribute('index')].completed;
    showData();
}

loadTodo();


