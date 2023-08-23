import React, { useState } from 'react';
import Message from '../Message/Message';



export default function Pizza():JSX.Element {
   const [pizza, setPizza] = useState<string>('Make pizza: ');

   

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
        setPizza('Make pizza: ');
     }
   return (
   <div className="container">
    <h1>Pizza</h1>
 
    <button type="button" onClick={handleAddMushrooms}>mushrooms</button>
    <button type="button" onClick={handleAddTomatoes}>tomatos</button>
    <button type="button" onClick={handleSalami}>salami</button>
    <button type="button" onClick={handleChees}>cheese</button>
    <button type="button" onClick={handleNewPizza}>Clear</button>
    <Message msg={pizza} title=''/>
   </div>

   );
}
