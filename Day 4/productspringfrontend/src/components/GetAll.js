import React, { useEffect, useState } from 'react';
import axios from 'axios';

export default function GetAll() {

    const [products, setProducts] = useState([]);

    useEffect(() => {
        loadProducts();
    }, []);

    const loadProducts = async () => {
        const result = await axios.get("http://localhost:8080/products");
        setProducts(result.data);
    }
    return (
        <div className='py-4'>
            <div className="row">
                {products.map((product, index) => (
                    <div className="col-md-3" key={index}>
                        <a className="card1" href="#">
                            <p><strong>Name:</strong> {product.name}</p>
                            <p><strong>Type:</strong> {product.type}</p>
                            <p><strong>Place:</strong> {product.place}</p>
                            <p><strong>Warranty:</strong> {product.warranty}</p>

                        </a>
                    </div>
                ))}
            </div>
        </div>

    )
}