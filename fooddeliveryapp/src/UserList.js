import React, {Component} from 'react';
import { Button } from 'reactstrap';
export default class UserList extends React.Component {
    constructor(props) {
      super(props);
      this.state = {customers: [], loading:true};
    }
  
    async componentDidMount() {
        const url = "http://localhost:8080/customer";
        const response = await fetch(url);
        const data = await response.json();
        console.log(data);   
        this.setState({
            customers:data,
            loading:false
        })
    }
  
  
  
    render() {

        // if (this.state.customers.length > 0){
        //     console.log("customers");
        //     console.log(this.state.customers)
        // }
        // if (this.state.customers.length > 0){
        //     const customers = this.state.customers.map((customer, i) => (
        //         <div>
        //           <h1>{ customer.id }</h1>
        //           <span> { customer.firstName }</span>
        //         </div>
        //       ));
        // }


    
      return (
        <div>
            { this.state.loading ? (
                <div> loading..</div>
            ): (
                <div>
                    <div>{this.state.customers[0].id}</div>
                    <div>{this.state.customers[0].firstName}</div>
                </div>
            )}
        </div>
      );
    }
}
  
