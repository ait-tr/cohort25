import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App/App';
import reportWebVitals from './reportWebVitals';
import Message from './Message/Message';
import Counter from './Counter/Counter';
import Apple from './Apple/Apple';
import Pizza from './Pizza/Pizza';
import Pizza2 from './Pizza2/Pizza2';
import Pizza3 from './Pizza3/Pizza3';

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
root.render(
  //<React.StrictMode>
    <>
        <Message msg='hello from index' title='qwe' />
        <Pizza2 />
        <Apple />
        <Pizza />
        <Counter />
        <Pizza3 />
    </>
  //</React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
