import React, { useState } from 'react';
import {
  Collapse,
  Navbar,
  NavbarToggler,
  NavbarBrand,
  Nav,
  NavItem,
  NavLink,
  UncontrolledDropdown,
  DropdownToggle,
  DropdownMenu,
  DropdownItem } from 'reactstrap';



  export default class Example extends React.Component {

    constructor(props){
        super(props);
        this.state = {
            isLoggedIn:false,
            isOpen:false,
            setIsOpen:false
        };
    }

    toggle(){
      this.setState({
        setIsOpen: !this.state.setIsOpen
      })
    }
    componentDidMount(){
      console.log(this.props.loggedIn)
    }
    execute(){
      console.log("going inside execute function---")
      localStorage.clear();
      window.location.href = 'http://localhost:3000/new';
    }
    executeOrder(){
      window.location.href = 'http://localhost:3000/orders';
    }
    render(){
      return (
        <div>
          <Navbar color="light" light expand="md">
            <NavbarBrand href="/">HungryBellies.com</NavbarBrand>
            <NavbarToggler onClick={this.toggle} />
            <Collapse isOpen={this.state.isOpen} navbar>
              <Nav className="ml-auto" navbar>


              { this.props.loggedIn ?  <NavItem>
                  <NavLink onClick={this.executeOrder}>Orders</NavLink>
                </NavItem> : null}
                
                { this.props.loggedIn ?  <NavItem>
                  <NavLink onClick={this.execute}>LogOut</NavLink>
                </NavItem> : <NavItem>
                  <NavLink href="/register">Sign Up</NavLink>
                </NavItem>}
                
                { this.props.loggedIn ? null : <NavItem>
                  <NavLink href="/login">Login</NavLink>
                </NavItem>}

                <NavItem>
                  <NavLink href="/cart"> My Cart</NavLink>
                </NavItem> 
              </Nav>
            </Collapse>
          </Navbar>
        </div>
      );

    }

  }

