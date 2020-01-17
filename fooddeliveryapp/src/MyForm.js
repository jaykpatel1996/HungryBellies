import React, {Component} from 'react';
import { Button } from 'reactstrap';
class MyForm extends React.Component {

   handleSubmit(event){
       event.preventDefault();
       console.log(event.target);
       let firstName = event.target.firstName.value;
       let lastName = event.target.lastName.value;
       let email = event.target.email.value;
       let id = Math.ceil(Math.random() * 200)
    //    let id = "12566";
       let phoneNumber = event.target.phone.value;
       let password = event.target.password.value;
        
       fetch('/customer/', {
        method: 'POST',
        headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        },
        body: JSON.stringify({
              emaiId: email,
              firstName: firstName,
              id:id,
              lastName:lastName,
              phoneNumber:phoneNumber,
              password:password
            })
        }).then(function(response){
                console.log('response is');
                console.log(response);
        })
       console.log("going insde handle submit handler....")

        window.location.href = 'http://localhost:3000/new';
       
   }

    render(){
    return(
        <form onSubmit={this.handleSubmit}>
            <h1>User Registration</h1>
            <p> First Name</p>
            <input type="text" name="firstName" id="firstName" placeholder="First Name" />
            <p> Last Name</p>
            <input type="text" name="lastName" id="lastName" placeholder="Last Name" />
            <p> Email Address </p>
            <input type="email" name="email" id="email" placeholder="Email" />
            <p> Phone Number</p>
            <input type="text" name="phone" id="phone" placeholder="Phone" />
            <p> Home Address</p>
            <input type="text" name="address" id="address" placeholder="address"/>
            <br />
            <p>Password</p>
            <input type="password" name="password" id="password" />
            <br />   
            <Button color="primary">Submit Form</Button>        

        </form>
    )}
}

export default MyForm;