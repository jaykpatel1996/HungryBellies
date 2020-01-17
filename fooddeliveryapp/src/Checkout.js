import React from 'react'
import StripeCheckout from 'react-stripe-checkout';
import { Link, withRouter } from "react-router-dom";

 class Checkout extends React.Component {
   state = {
     customer:{}
   }
  handleToken = (token, addresses) => {
    var vm = this;
    // TODO: Send the token information and any other
    // relevant information to your payment process
    // server, wait for the response, and update the UI
    // accordingly. How this is done is up to you. Using
    // XHR, fetch, or a GraphQL mutation is typical.
    console.log({token , addresses})
    console.log("payment completed!");
    console.log(this.props.products);
    let totalPrice = 0
    this.props.products.map(item => {
        totalPrice = totalPrice + item.price * item.units;   
    })
    console.log("total price is" +totalPrice);
    console.log("email id is")
    console.log(localStorage.getItem('email'))
    let customer = {}
    let id = Math.ceil(Math.random() * 2000)

    fetch('/customer_order/', {
      method: 'POST',
        headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Credentials': true,
      'Access-Control-Request-Headers': 'access-control-allow-credentials,access-control-allow-methods,access-control-allow-origin,allow,content-type',
      'mad' : localStorage.getItem('email')
        },
        body: JSON.stringify({
              cost: totalPrice,
              id: id,
              items:this.props.products,
              status:"true"
  })
}).then(function(response){
  console.log('going into order bithh..');
  // console.log(response.json());
})
    


    // fetch('http://localhost:8080/customerLogin/'+localStorage.getItem('email'))
    //     .then(function(response){
    //       console.log("inside customer login----")
    //       return response.json()
    //     })
    //     .then(function(response){
    //       // console.log(response);
    //       customer = response;
    //       console.log(customer);
    //       console.log("customer list of orders");
    //       console.log(customer.listOfOrders);
    //     })
        

        console.log("outside function");
        console.log(customer);

    
//     fetch('http://localhost:8080/customer/aki@gmail/order/', {
//         method: 'POST',
//         headers: {
//         'Accept': 'application/json',
//         'Content-Type': 'application/json',
//         'Access-Control-Allow-Origin':'*'
//         },
//         body: JSON.stringify({
//               cost: totalPrice,
//               id: '123',
//               items:this.props.products,
//               status:true
//   })
// }).then(function(response){
//   console.log('successfully added order and customer');
//   // console.log(response.json());
// })






    

    this.props.history.push('/new');
  };

  componentDidMount(){
      console.log("props is");
      console.log(this.props.products);
  }

  render() {
    return (
      <StripeCheckout
        stripeKey="pk_test_4roCqkYjcIQ3T2LvxtMzBhmD"
        token={this.handleToken}
        billingAddress
        shippingAddress
      
      />
    )
  }
}
export default withRouter(Checkout);