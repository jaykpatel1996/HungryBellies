import React from "react";
import SearchBar from "./SearchBar";
import Example from "./Example";
import { isV8IntrinsicIdentifier } from "@babel/types";

const styles = {
    color:'violet',
    backgroundImage: 'url(' + require('./image.png') + ')',
    width:"100%",
    height:"400px"
    };

export default class Home extends React.Component {
    constructor(props){
        super(props);
        
        this.state = {
            loggedIn:false
        }
    }

    // toggle(s){
    //     console.log(s)
    //     if (s){
    //         this.setState({
    //             url:true
    //         })
    //         console.log("going inside");
    //     }
    //     else {
    //         console.log("not going inside");
    //     }
    // }
    render(){
        console.log("home component")
        var s = window.location.search.split('loggedIn=')[1]
        // this.toggle(s)
        // console.log(s)

        
        // if (s.equals(true)){
        //     console.log("this is true")
        //     this.setState({
        //         loggedIn:true
        //     })
        // }

        return (
            <div style={styles}>
                <Example loggedIn = {s}/>
                <SearchBar/>
            </div>
        )
   }
}