import React from "react";

export default class FetchRandomUser extends React.Component{

    state = {
        loading:true
    };
    async componentDidMount(){
        const url = "https://api.randomuser.me/";
        const response = await fetch(url);
        const data = await response.json();
        console.log(data);   
    }
    render(){
        return <div> {this.state.loading ? <div>loading...</div> : <div> Person...</div>}
        </div>
    }
}