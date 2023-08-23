import React from 'react'
import { Outlet } from 'react-router-dom'
import NavBar from '../NavBar/NavBar'
import Users from '../Companents/Users/Users'
import Shop from '../Companents/Shop/Shop'

export default function Layout():JSX.Element {
 
    return (
    <>    
        <div>Layout</div>
        <NavBar />
        <Outlet />
        <hr/>
        <Shop />

    </>
  )
}
