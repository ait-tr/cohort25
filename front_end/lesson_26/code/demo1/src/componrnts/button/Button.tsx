import React from 'react'
import { useDispatch } from 'react-redux'
interface Props {
  amount:number;
}

export default function Button({amount}:Props) {
  const dispatch= useDispatch()

  function handlePlus(){
    dispatch({type: "counter/plus", payload:amount })
  }
  function handleMinus(){
    dispatch({type: "counter/minus", payload:amount })
  }

    return (
    <div>
      <button type="button" onClick= {handlePlus}>add {amount} kg</button>
      <button type="button" onClick= {handleMinus}>- {amount} kg</button>
    </div>
  )
}
