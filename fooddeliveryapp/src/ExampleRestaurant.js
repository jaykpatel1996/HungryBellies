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



  export default class ExampleRestaurant extends React.Component {

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
    render(){
      return (
        <div>
          <Navbar color="light" light expand="md">
            <NavbarBrand href="/">HungryBellies.com</NavbarBrand>
            <NavbarToggler onClick={this.toggle} />
            <Collapse isOpen={this.state.isOpen} navbar>
              <Nav className="ml-auto" navbar>
                { this.props.loggedIn ?  <NavItem>
                  <NavLink onClick={this.execute}>LogOut</NavLink>
                </NavItem> : <NavItem>
                  <NavLink href="/registerRestaurant">Sign Up</NavLink>
                </NavItem>}
                
                { this.props.loggedIn ? null : <NavItem>
                  <NavLink href="/loginRestaurant">Login</NavLink>
                </NavItem>}

                
                
              </Nav>
            </Collapse>
          </Navbar>
        </div>
      );

    }

  }