let url='https://jsonplaceholder.typicode.com/users/1/todos';

function loadToDo(){
    let response= fetch(url);

    response.then((response)=>{
        dataPromise = response.json();
        dataPromise.then((res)=>{
           console.log(res); // put on the page    
        }            
        )
    });
    
}

loadToDo();


