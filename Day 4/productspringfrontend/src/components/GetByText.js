import React, { useEffect, useState } from 'react';
import axios from 'axios';
import '../App.css';

export default function GetByText() {
    const [products, setProducts] = useState([]);

    useEffect(() => {
        loadProducts();
    }, []);

    const loadProducts = async (str) => {
        let apiUrl = "http://localhost:8080/products";
        
        if (str && str.trim() !== "") {
          // If search term is present, update the API URL with the search parameter
          apiUrl += `/findall/${encodeURIComponent(str)}`;
        }
      
        const result = await axios.get(apiUrl);
        setProducts(result.data);
      };
      
      


    return (
        <div class="container justify-content-center">

            <div class="row">

                <div class="col-md-8">

                    <div class="input-group mb-3">
                        <input
                            type="text"
                            class="form-control input-text"
                            placeholder="Search products...."
                            aria-label="Recipient's username"
                            aria-describedby="basic-addon2"
                            onChange={(e) => loadProducts(e.target.value)}
                        />

                        <div class="input-group-append">
                            <button class="btn btn-outline-warning btn-lg" type="button"><i class="fa fa-search"></i></button>
                        </div>
                    </div>

                </div>

            </div>
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
        </div>
    )
}