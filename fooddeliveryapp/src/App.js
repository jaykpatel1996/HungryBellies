import React, {Component} from 'react';
import logo from './logo.svg';
import MyForm from './MyForm';
import './App.css';
import SearchBar from './SearchBar';
import Example from './Example';
import Home from './Home';
import Restaurant from './Restaurant';
import { BrowserRouter,Route} from "react-router-dom"
import style from './style.css'
import Checkout from './Checkout';
import Login from './Login';
import Orders from './Orders';


// const styles = {
//   color:'violet',
//   backgroundImage: 'url(' + require('./image.png') + ')',
//   width:"100%",
//   height:"400px"
//   };
  const imageStyles = {
    height:"60px",
    width:"30px"
  };


 
class App extends Component {
  
  constructor(){
    super();
    this.state={
      search:''
    };
  }

  componentDidMount(){
    console.log(localStorage.getItem('email'));
    
  }
  render() {
    return (
      <div>
        <div className="App">
          
          <BrowserRouter>
            <Route exact path="/new" component={Home} />
            <Route path="/register" component={MyForm} />
            <Route path="/restaurant" component={Restaurant} />
            <Route path="/checkout" component={Checkout} />
            <Route path="/login" component={Login} />
            <Route path="/orders" component={Orders} />
        </BrowserRouter>
        </div>
      
          </div>


    
      
      
    );
  }
}

export default App;