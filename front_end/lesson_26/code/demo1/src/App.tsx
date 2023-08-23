import React from 'react';
import './App.css';
import Dysplay from './componrnts/dysplay/Dysplay';
import Button from './componrnts/button/Button';

function App() {
  return (
   <>
   <Dysplay />
   <Button amount={0.1} />
   <Button amount={1} />
   <Button amount={10} />
   <Button amount={100} />
   
   </>
  );
}

export default App;
