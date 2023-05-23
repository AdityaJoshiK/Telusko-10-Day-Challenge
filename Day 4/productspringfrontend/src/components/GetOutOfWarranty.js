import React, { useEffect, useState } from 'react';
import axios from 'axios';
import '../App.css';

export default function GetOutOfWarranty() {
    const [products, setProducts] = useState([]);

    useEffect(() => {
        loadProducts();
    }, []);

    const loadProducts = async (str) => {
        const result = await axios.get("http://localhost:8080/products/outwarranty");
        setProducts(result.data);
      };
      
      


    return (
        <div class="container justify-content-center">
<div className='py-4'>
            <div className="row">
                {products.map((product, index) => (
                    <div className="col-md-3" key={index}>
                        <a className="card1" href="#">
                            <p><strong>Name:</strong> {product.name}</p>
                            <p><strong>Type:</strong> {product.type}</p>
                            <p><strong>Place:</strong> {product.place}</p>
                            <p><strong style={{color:"red"}}>Warranty:</strong> {product.warranty}</p>

                        </a>
                    </div>
                ))}
            </div>
        </div>
        </div>
    )
}