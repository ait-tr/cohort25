
import React, { useEffect, useState } from 'react'
import { ProductData } from '../../types/ProductData';


export default function Shop() {
const url ='https://fakestoreapi.com/products';
const data:ProductData ={
    products:[],
};

const[productData, setProductData] = useState<ProductData>(data)

const loadProductData = async function(): Promise<void> {
    const res = await fetch(url);
    const arr= await res.json();
    setProductData({...productData, products:arr});
    //setProductData({... state, new value of fields });
}

useEffect( ()=>{ loadProductData() }, [] );


function productHandler(){
    const{products}=productData;
    return products.map((product)=>(
     <li className='product'>
        <span className='product id'>{product.id}</span>
        <span className='product title'>{product.title}</span>
        <span className='product price'>{product.price}</span>
        <div>
            <img className='product image' src={product.image}  alt='product'/>
        </div>
     </li>
    )     
    )
}

  
  return (
    <>
        <div className='header'>Shop</div>
        <ul className='product list'>
            {productHandler()}
        </ul>
    </>
  )
}
