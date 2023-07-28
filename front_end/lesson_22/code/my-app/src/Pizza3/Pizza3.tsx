import React, { useState } from 'react';
import Message from '../Message/Message';



export default function Pizza3():JSX.Element {
   
   const init:string = 'Make pizza: ';
   const [pizza, setPizza] = useState<string>(init);

      function handleAddMushrooms(): void {
        setPizza(`${pizza} mushrooms`);
     }
     function handleAddTomatoes(): void {
        setPizza(`${pizza} tomatos`);
     }
     function handleSalami(): void {
        setPizza(`${pizza} salami`);
     }
     function handleChees(): void {
        setPizza(`${pizza} cheese`);
     }
     function handleNewPizza(): void {
        setPizza(init);
     }

     

     function handleClearLast(): void {
      if(pizza!=init){
        const arr:string[]= pizza.split(" ");
        arr.pop();  
        setPizza(arr.join(" "));
      }
   }

   return (
   <div className="container">
    <h1>Pizza</h1>
    <h2>{pizza}</h2>
    <button type="button" onClick={handleAddMushrooms}>mushrooms</button>
    <button type="button" onClick={handleAddTomatoes}>tomatos</button>
    <button type="button" onClick={handleSalami}>salami</button>
    <button type="button" onClick={handleChees}>cheese</button>
    <button type="button" onClick={handleClearLast}>Clear Last</button>
    <button type="button" onClick={handleNewPizza}>Clear</button>
   </div>

   );
}