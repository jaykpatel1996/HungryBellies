import React, { Component } from 'react';
import { Button } from 'reactstrap';
export default class Orders extends React.Component {

   constructor(props){
       super(props);
        this.state = {
            listOfOrders: []
        }
   }

  

   componentDidMount(){
       var vm = this;
       console.log(localStorage.getItem('email'))
       fetch('/customerLogin/'+localStorage.getItem('email'))
        .then(function(response){
            return response.json()
        })
        .then(function(response){
            console.log(response.listOfOrders);
            vm.setState({
                listOfOrders: response.listOfOrders
            })
            
        })
   }
    render(){
    return (
        <div>
            <p> Your Orders</p>

            <br />

            {
                this.state.listOfOrders.length > 0 ? this.state.listOfOrders.map(order=>{
                    return (
                        <div>
                        <p> Order id {order.id}     Order cost {order.cost}</p>
                        { order.items.map(item => {
                            return (
                                <div>
                                    <p> Item id {item.id} </p>
                                    <p>Item name {item.itemName}</p>
                                </div>
                            )
                        })}
                        </div>
                    )     
                }) : null
            }

                 
            {/* { this.state.listOfOrders.length > 0 && this.state.listOfOrders.map(order=>{
                <div>
                <p> Order id {order.id}</p>
                <p> Order cost {order.cost}</p>
                </div>
            })
        } */}

        </div>
    )
}
}