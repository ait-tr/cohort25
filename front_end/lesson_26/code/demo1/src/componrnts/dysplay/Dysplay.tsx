import React from 'react'
import { useSelector } from 'react-redux'
import { RootState } from '../../store'

export default function Dysplay() {
    const value= useSelector((state:RootState)=> state.counter.value)
  return ( 
    <>
        <div>The current value is</div>
        {value}
    </>
  )
}
