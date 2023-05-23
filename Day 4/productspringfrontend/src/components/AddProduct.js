import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import { Link } from 'react-router-dom'

export default function AddProduct() {

    const [Product, setProduct] = useState({
        name: '',
        type: '',
        place: '',
        warranty: ''
    })

    let navigate = useNavigate()

    const {name,type,place,warranty} = Product;

    const onInputChange=(e)=>{
        setProduct({...Product, [e.target.name]:e.target.value})
    }

    const onSubmit= async(e)=>{
        e.preventDefault();
        await axios.post("http://localhost:8080/product",Product)
        navigate("/")

    }
    return(
        <div className="container">
        <div className="row">
          <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
            <h2 className="text-center m-4">Add Product</h2>
  
            <form onSubmit={(e) => onSubmit(e)}>
              <div className="mb-3">
                <label htmlFor="Name" className="form-label">
                  Name
                </label>
                <input
                  type={"text"}
                  className="form-control"
                  placeholder="Enter name"
                  name="name"
                  value={name}
                  onChange={(e) => onInputChange(e)}
                />
              </div>
              <div className="mb-3">
                <label htmlFor="type" className="form-label">
                  Type
                </label>
                <input
                  type={"text"}
                  className="form-control"
                  placeholder="Enter Type"
                  name="type"
                  value={type}
                  onChange={(e) => onInputChange(e)}
                />
              </div>
              <div className="mb-3">
                <label htmlFor="place" className="form-label">
                  Place
                </label>
                <input
                  type={"text"}
                  className="form-control"
                  placeholder="Enter Place"
                  name="place"
                  value={place}
                  onChange={(e) => onInputChange(e)}
                />
              </div>
              <div className="mb-3">
                <label htmlFor="warranty" className="form-label">
                warranty
                </label>
                <input
                  type={"text"}
                  className="form-control"
                  placeholder="Enter warranty"
                  name="warranty"
                  value={warranty}
                  onChange={(e) => onInputChange(e)}
                />
              </div>
             
              <button type="submit" className="btn btn-outline-primary">
                Submit
              </button>
              <Link className="btn btn-outline-danger mx-2" to="/">
                Cancel
              </Link>
            </form>
          </div>
        </div>
      </div>
    )
}