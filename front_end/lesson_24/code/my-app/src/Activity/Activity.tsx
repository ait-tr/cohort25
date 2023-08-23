import {useState, useEffect} from "react";
export default function Activity():JSX.Element {
    //{"activity":"Go to a concert with some friends","type":"social","participants":4,"price":0.6,"link":"","key":"4558850","accessibility":0.4}
    const url:string = 'https://www.boredapi.com/api/activity'; 

    interface ActivityData{
        activity:string;
        type:string;
        participants:number;
        price:number;
        link:string;
        key:string;
        accessibility:number;
    }

    const initActivityData:ActivityData={
        activity: "",
        type: "",
        participants: 0,
        price: 0,
        link: "",
        key: "",
        accessibility: 0
    };

    const [actualActivity, setActualActivity] = useState<ActivityData>(initActivityData);
    const [temp, setTemp] = useState<number>(0);
    const [temp2, setTemp2] = useState<number>(0);

    async function loadActivityData(){
        console.log("loadActivityData");
        
        const res:Response = await fetch(url);
        const data:ActivityData = await res.json();
        setActualActivity(data);
        
    }

    useEffect(()=>{ loadActivityData()},[temp] );

    function btnHandler(){
        setTemp(temp+1);
    }

    function btnHandler2(){
        setTemp2(temp2+1);
    }


    return(
    <>
     <h1>{actualActivity.activity}</h1>
     <h2>participants: {actualActivity.participants}</h2>
     <h2>price: {actualActivity.price}</h2>
     <h2>type: {actualActivity.type}</h2>
     <h2>link: {actualActivity.link}</h2>
     
     <button type="button" onClick={btnHandler}>click me (temp)</button>
     <button type="button" onClick={btnHandler2}>click me (temp 2)</button>
    </>
    )
}