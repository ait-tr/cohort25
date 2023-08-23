import React from 'react';
import logo from './logo.svg';
import './App.css';
import { Route, Routes } from 'react-router-dom';
import Layout from '../Layout/Layout';
import Page1 from '../Companents/Page1/Page1';
import Page2 from '../Companents/Page2/Page2';
import Page3 from '../Companents/Page3/Page3';
import ErrorPage from '../Companents/ErrorPage/ErrorPage';
import Users from '../Companents/Users/Users';

function App() {
  return (
    <Routes>
      <Route path='/' element={<Layout />}>

        <Route path='page1' element={<Page1 />} />
        <Route path='page2' element={<Page2 />} />
        <Route path='page3' element={<Page3 />} />
        <Route path='*' element={<ErrorPage />} />
        <Route path='users/:userId' element={<Users />} />
        <Route path='users/:userId/orders/:orderId' element={<Users />} />
      </Route>
    </Routes>
  );
}


export default App;
////<Route path='users/:userId/orders/:orderId' element={<Users />} />