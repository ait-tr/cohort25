import React from 'react'
import { NavLink } from 'react-router-dom'

export default function NavBar() {
  return (
    <nav>
        <div>NavBar</div>
        <NavLink to="/">Homepage</NavLink>
        <NavLink to="page1">page1</NavLink>
        <NavLink to="page2">page2</NavLink>
        <NavLink to="page3">page3</NavLink>
    </nav>
  )
}
