import React, { Component } from 'react';
import Product from './Product';
import { Link } from 'react-router-dom';
import Products from './Products';
import { NavItem, NavLink } from 'reactstrap';
import Checkout from './Checkout';
import { Button } from 'reactstrap';



let items = []

// const products = [
//     {
//         id:1,
//         name:"Apple",
//         description:"",
//         img:"https://tachyons.io/img/avatar_1.jpg",
//         price:100
//     },
//     {
//         id:2,
//         name:"A Cat",
//         description:"Chief Cat Officer",
//         img:"https://tachyons.io/img/avatar_1.jpg",
//         price:100
//     },
//     {
//         id:3,
//         name:"Milk",
//         description:"Milk for the lactose tolerant",
//         img:"https://tachyons.io/img/avatar_1.jpg",
//         price:100
//     },
//     {
//         id:4,
//         name:"Banana",
//         description:"I need those carbs",
//         img:"https://tachyons.io/img/avatar_1.jpg",
//         price:100
//     },
//     {
//         id:5,
//         name:"Watermelon",
//         description:"Summer fruit",
//         img:"https://tachyons.io/img/avatar_1.jpg",
//         price:100
//     }
// ];

function Header(props){
    return <h1> Shopping cart</h1>
}
function Footer(props){
    return <h2> {props.total}</h2>
} 
function Items(props){
    return <table class="center">
        <tr><th>Name</th>
            <th>Count</th>
            <th>Price</th>
            <th>Total</th>
        </tr>
        {
            props.productItems.map(item => 
                <tr>
                    <td>{item.name}</td>
                    <td>{item.units}</td>
                    <td>{item.price}</td>
                    <td>{item.price * item.units}</td>
                </tr>
                )
        }
 
         {/* {
             props.productItems.map(item => this.state.totalPrice  = this.state.totalPrice + item.price * item.units)
        } */}
    </table>
}

class Restaurant extends Component {

    state={
        cart:[
            // {
            //     id:4,
            //     name:"Banana",
            //     description:"I need those carbs",
            //     img:"https://tachyons.io/img/avatar_1.jpg",
            //     price:100,
            //     units:1
            // }
        ],
        display:false,
        totalPrice:20,
        products:[],
        reviews:[]
    };


    findProductIndex = (cart,productId)=> {
        return cart.findIndex(p => p.id === productId);
    }

    updateProductUnits = (cart,product) => {
        
        const productIndex = this.findProductIndex(cart,product.id);
        
            const updatedProducts = [...cart];
            const existingProduct = updatedProducts[productIndex];
            const updatedUnitsProduct = {
                ...existingProduct,
                units:existingProduct.units + product.units
            }
            updatedProducts[productIndex] = updatedUnitsProduct;
            return updatedProducts;
    }

    computeTotalPrice = () => {
        console.log("inside compute total price");
        console.log(this.state.cart);
        let totalPrice = 0
        this.state.cart.map(item => {
            totalPrice = totalPrice + item.price * item.units;   
        })
        console.log("total price is" +totalPrice)
        this.setState({
            totalPrice: totalPrice
        })
    }
  


    addToCart = (product) =>{
        const {cart} = this.state;
        const existingProductIndex = this.findProductIndex(cart,product.id);
        this.setState({
            cart: existingProductIndex >=0 ? this.updateProductUnits(cart,product):[...cart,product]
        })
    };
    // changeDisplay(){
    //     this.setState({
    //         display:!this.state.display
    //     })
    // }

    
   
    componentDidMount(){
        document.getElementById('review').value = ''
        var vm = this;
        console.log("restaurant component mounted...");
        let paths = window.location.pathname.split('/');
        console.log(paths[2]);
        fetch('/restaurants?name='+paths[2])
            .then(function(response){
                return response.json();
            })
            .then(function(data){
                console.log("restaurant reviews is---")
                console.log(data[0].reviews);
                vm.setState({
                    reviews:data[0].reviews
                })
                items = data[0].listOfItems;
                // console.log(data[0].id)
                localStorage.setItem('restaurantId',data[0].id)
               return items
            })
           .then(function(response){
               console.log(vm);
               console.log("response is")
               console.log(response)
               vm.setState({
                   products:response
               })
           })
      

        // console.log(this.state.products);
    }
    submitReview(e){
        var review = document.getElementById('review').value
        document.getElementById('review').value = ''
        console.log("Going into submit review");
        // console.log(review);
        fetch('/restaurantReview/'+localStorage.getItem('restaurantId'), {
            method:'POST',
            headers :{
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                id:Math.ceil(Math.random() * 200),
                reviewDescription:review
            })
        })
        .then(function(response){
            console.log(response)
        })
            
    }
    render(){
        var vm = this;
            console.log("products is")
            console.log(vm.state.products)
            return <div>
                
            <div className="flex flex-wrap justify-between">
                
             <ul>
                 {this.state.cart.length > 0 ? <Header />:null}
                 {this.state.cart.length > 0 ? <Items productItems={this.state.cart} />:null}
                {/* {this.state.cart.map(c => <li>{c.name} | units {c.units}</li>)}   */}
                {this.state.cart.length > 0 ? <Footer total={this.state.cart.reduce((a,c)=>(a + c.price * c.units),0)} />:null}
                { this.computeTotalPrice}
                {/* <span onClick={this.computeTotalPrice}>CheckOut</span> */}
                {this.state.cart.length > 0 ? <Checkout products = {this.state.cart}/> : null}
            </ul>
            
                {
                    this.state.products.map(p => (<Product  { ...p} addFunc={this.addToCart} />))
                }
         
                
        </div>

<div>
<input type="text" style={{width: "370px"}} id="review"  name="review" size="10" />
<br />
<br />
<Button color="primary" onClick={this.submitReview}>Submit Review</Button>       
</div>
<p> List of reviews are </p>
{
    
    this.state.reviews.length > 0 ? this.state.reviews.map(review => {
        return (
            <div>
                <p>{review.reviewDescription}</p> 
            </div>
        )
    }):null
}
</div>

       
        
      
        
        
    }
}
export default Restaurant;


{/* <div><Link to='/checkout'><Button variant="primary">Checkout</Button></Link></div> */}