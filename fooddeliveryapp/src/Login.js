import React, { Component } from 'react';
import { Button } from 'reactstrap';
export default class Login extends React.Component {

   constructor(props){
       super(props);
       this.state = {
           email: "",
           password:"",
           loginErrors:"",
           isLoggedIn:false
       };
       this.handleSubmit = this.handleSubmit.bind(this);
       this.handleChange = this.handleChange.bind(this);
   }

   handleChange(event){
       this.setState({
           [event.target.name]:event.target.value
       })
   }

   handleSubmit(event){
       event.preventDefault();
       var vm = this;
       const { email, password } = this.state;
       console.log(email);
       console.log(password);
       fetch("http://localhost:9000/customerLogin/"+email)
        .then(function(response){
            alert("going inside");
            // console.log(response.json());
            return response.json()
        })
        .then(function(response){
            console.log(response);
            console.log("password is ");
            console.log(response.password)
            if (response.password === vm.state.password){
                alert("passwords match")
                localStorage.setItem('email',response.emaiId)
                console.log(response.emaiId);
                console.log(localStorage.getItem('email'))
                vm.setState({
                    isLoggedIn:true
                })
                window.location.href = 'http://localhost:3000/new?loggedIn=true'
            }
            else {
                alert("passwords don't match");
            }
        })
   }
//    handleSubmit(event){
//        event.preventDefault();
//        console.log(event.target);
//        let firstName = event.target.firstName.value;
//        let lastName = event.target.lastName.value;
//        let email = event.target.email.value;
//        let id = "12";
//        let phoneNumber = event.target.phone.value;
//        let password = event.target.password.value;
        
//        fetch('http://localhost:8080/customer/', {
//         method: 'POST',
//         headers: {
//         'Accept': 'application/json',
//         'Content-Type': 'application/json',
//         },
//         body: JSON.stringify({
//               emailId: email,
//               firstName: firstName,
//               id:id,
//               lastName:lastName,
//               phoneNumber:phoneNumber,
//               password:password
//             })
//         }).then(function(response){
//                 console.log('response is');
//                 console.log(response);
//         })
//        console.log("going insde handle submit handler....")

//         window.location.href = 'http://localhost:3000/new';
       
//    }

    render(){
    return (
        <div>
            <form onSubmit = {this.handleSubmit}>
            <p> Email</p>
            <input type="text" name="email" id="email" onChange={this.handleChange}/>
            <p> Password</p>
            <input type="password" name="password" id="password" onChange={this.handleChange} />
            <br />   
            <Button type="submit">Login</Button>  
            </form>
        </div>
    )
}

}