import React, { Component } from 'react'
import { Link } from 'react-router-dom'

class Navbar extends Component {
    // constructor(props) {
    //     super(props)

    //     this.state = {
                 
    //     }
    // }

    render() {
        return (
            <nav class=" navbar navbar-dark bg-primary navbar-expand-lg ">
  <a class="navbar-brand" href="#">Product Management</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <Link class="nav-link" to="/">Home</Link>
      </li>
      <li class="nav-item">
        <Link  class="nav-link" to="/getall" type='submit'>GetAll</Link>
      </li>
      <li class="nav-item">
        <Link  class="nav-link" to="/getname" type='submit'>GetName</Link>
      </li>
      <li class="nav-item">
        <Link  class="nav-link" to="/getplace" type='submit'>GetPlace</Link>
      </li>
      <li class="nav-item">
        <Link  class="nav-link" to="/getbytext" type='submit'>GetByText</Link>
      </li>
      <li class="nav-item">
        <Link  class="nav-link" to="/getoutofwarranty" type='submit'>GetOutOfWarranty</Link>
      </li>
     
    </ul>
      {/* <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button> */}
      <Link to="/addproduct" class="btn btn-success text-right"  style={{marginLeft: 650 + 'px'}} type="submit">Add Product</Link>
  </div>
</nav>
        )
    }
}

export default Navbar