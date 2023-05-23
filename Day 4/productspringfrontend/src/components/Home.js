import React, { useEffect, useState } from 'react';
import axios from 'axios';

export default function Home() {

    const [products, setProducts] = useState([]);
    const [totalOutdtedProducts, setTotalOutdtedProducts] = useState(0);
    const [totalProducts, setTotalProducts] = useState(0);
  const [totalPlaces, setTotalPlaces] = useState(0);
  const [totalTypes, setTotalTypes] = useState(0);

    useEffect(() => {
        loadProducts();
    }, []);

    const loadProducts = async () => {
        const result = await axios.get("http://localhost:8080/products");
        setProducts(result.data);

        const countResult = await axios.get("http://localhost:8080/products/countoutwarranty");
    setTotalOutdtedProducts(countResult.data);

    const productsCountResult = await axios.get("http://localhost:8080/products/countproducts");
    setTotalProducts(productsCountResult.data);

    const placesCountResult = await axios.get("http://localhost:8080/products/countplaces");
    setTotalPlaces(placesCountResult.data);

    const typesCountResult = await axios.get("http://localhost:8080/products/counttypes");
    setTotalTypes(typesCountResult.data);
    }
    return (
        <div class="main-content">
        <div class="header bg-gradient-primary pb-8 pt-5 pt-md-8">
          <div class="container-fluid">
            <h2 class="mb-5 text-white">Stats Card</h2>
            <div class="header-body">
              <div class="row">
                <div class="col-xl-3 col-lg-6">
                  <div class="card card-stats mb-4 mb-xl-0">
                    <div class="card-body">
                      <div class="row">
                        <div class="col">
                          <h5 class="card-title text-uppercase text-muted mb-0">Products</h5>
                          <span class="h2 font-weight-bold mb-0">{totalProducts}</span>
                        </div>
                        <div class="col-auto">
                          <div class="icon icon-shape bg-danger text-white rounded-circle shadow">
                            <i class="fas fa-chart-bar"></i>
                          </div>
                        </div>
                      </div>
                      <p class="mt-3 mb-0 text-muted text-sm">
                        <span class="text-nowrap">Total Available Products</span>
                      </p>
                    </div>
                  </div>
                </div>
                <div class="col-xl-3 col-lg-6">
                  <div class="card card-stats mb-4 mb-xl-0">
                    <div class="card-body">
                      <div class="row">
                        <div class="col">
                          <h5 class="card-title text-uppercase text-muted mb-0">Out Of Warranty</h5>
                          <span class="h2 font-weight-bold mb-0">{totalOutdtedProducts}</span>
                        </div>
                        <div class="col-auto">
                          <div class="icon icon-shape bg-warning text-white rounded-circle shadow">
                            <i class="fas fa-chart-pie"></i>
                          </div>
                        </div>
                      </div>
                      <p class="mt-3 mb-0 text-muted text-sm">
                        <span class="text-nowrap">Out Of Warranty Products</span>
                      </p>
                    </div>
                  </div>
                </div>
                <div class="col-xl-3 col-lg-6">
                  <div class="card card-stats mb-4 mb-xl-0">
                    <div class="card-body">
                      <div class="row">
                        <div class="col">
                          <h5 class="card-title text-uppercase text-muted mb-0">Total Types</h5>
                          <span class="h2 font-weight-bold mb-0">{totalTypes}</span>
                        </div>
                        <div class="col-auto">
                          <div class="icon icon-shape bg-yellow text-white rounded-circle shadow">
                            <i class="fas fa-users"></i>
                          </div>
                        </div>
                      </div>
                      <p class="mt-3 mb-0 text-muted text-sm">
                        <span class="text-nowrap">Total Types Of Products</span>
                      </p>
                    </div>
                  </div>
                </div>
                <div class="col-xl-3 col-lg-6">
                  <div class="card card-stats mb-4 mb-xl-0">
                    <div class="card-body">
                      <div class="row">
                        <div class="col">
                          <h5 class="card-title text-uppercase text-muted mb-0">Total Available Places</h5>
                          <span class="h2 font-weight-bold mb-0">{totalPlaces}</span>
                        </div>
                        <div class="col-auto">
                          <div class="icon icon-shape bg-info text-white rounded-circle shadow">
                            <i class="fas fa-percent"></i>
                          </div>
                        </div>
                      </div>
                      <p class="mt-3 mb-0 text-muted text-sm">  
                        <span class="text-nowrap">Total Number Of Places</span>
                      </p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

    )
}