import { useState } from "react"

export default function Apple():JSX.Element{
    const[apple, setApple] = useState<string>('apple');

    const btnName:string = apple==='apple'?'eat':'new apple'; 
    const picName:string =(apple==='apple')?'https://media.istockphoto.com/id/184276818/de/foto/roter-apfel.jpg?s=612x612&w=0&k=20&c=HhxNnyYG6mUOA5bJUlDaoznzdIEtiJzQ5H73mG0ZAeU=':'https://st.depositphotos.com/2390973/2805/i/600/depositphotos_28054157-stock-photo-red-apple-core-on-a.jpg'; 

    function eatApple():void{
        apple=='apple'?setApple('stub'):setApple('apple');  
          
    }

    return (
        <>
            <button type="button" onClick={eatApple}>{btnName}</button>
            <h2>{apple}</h2>
            <img src={picName} alt=""></img> 
        </>
    )

}