import React from 'react';
import './App.css';
import WeatherForm from './components/WeatherForm';
import WeatherInfo from './components/WeatherInfo';

function App() {
  return (
    <div>
      <WeatherForm />
      <WeatherInfo />
    </div>
  );
}

export default App;
