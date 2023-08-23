import React from 'react'
interface User{
    name:string,
    email:string
}
interface Props{
    users:User[];
    index: number;
}

export default function UserCard({users,index}:Props) {
    
  return (
    <>
        <div>UserCard</div>
        <h1>{users[index].name}</h1>
        <h2>{users[index].email}</h2>
    </>
  )
}
