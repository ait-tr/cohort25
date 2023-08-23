import React from 'react';
import { Routes, Route } from 'react-router-dom';
import './App.css';

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path='/' >
          <Route path='/' />
          <Route path='/cart' />
          <Route path='/search' />
          <Route path='/pizza/:id' />
          <Route path='*' />
        </Route>
      </Routes>
    </div>
  );
}

export default App;
