import React from 'react'
import UserCard from '../UserCard/UserCard';
import { Navigate, useParams } from 'react-router-dom';

export default function Users() {
    
    const users=[
        {
            name:'User 0',
            email:'email 0'
        },
        {
            name:'User 1',
            email:'email 1'
        },
        {
            name:'User 2',
            email:'email 2'
        },
        {
            name:'User 3',
            email:'email 3'
        },


    ];

    const {userId} = useParams();
    //console.dir(useParams())
    if (Number(userId)>=users.length){
        return <Navigate to="/" />
    }

    return (
    <>
        <div>Users</div>
        {/* The red users is the props for UserCard 
            The {users} is the variable with array */}
        
        <UserCard users={users} index={Number(userId)} />
    </>
  )
}
/*
// users/10/orders/1
//   {
//      userId:'10',
//      orderId:'1'           
//    }
// users/1/orders/5
*/