import logo from './logo.svg';
import './home.css';
import Navbar from './components/Navbar';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import Home from './components/Home';
import { BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import AddProduct from './components/AddProduct';
import GetByProductName from './components/GetByProductName';
import GetByPlace from './components/GetByPlace';
import GetByText from './components/GetByText';
import GetOutOfWarranty from './components/GetOutOfWarranty';
import GetAll from './components/GetAll';

function App() {
  return (
    <div className='App'>
      <Router>
        {/* <div className='container-fluid'> */}
      <Navbar/>
      
        {/* </div> */}
          
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path='/addproduct' element={<AddProduct/> }/>
          <Route path='/getall' element={<GetAll/> }/>
          <Route path='/getname' element={<GetByProductName/> }/>
          <Route path='/getplace' element={<GetByPlace/> }/>
          <Route path='/getbytext' element={<GetByText/> }/>
          <Route path='/getoutofwarranty' element={<GetOutOfWarranty/> }/>
        </Routes>
      </Router>
    </div>
  );
}

export default App;
