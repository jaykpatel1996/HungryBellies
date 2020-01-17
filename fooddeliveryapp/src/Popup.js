import React from "react";
import { Redirect } from "react-router-dom";

export default class Popup extends React.Component {
    state = {
        redirect:false,
        restaurantName:''
    }
    setRedirect = (event) => {
        console.log("inside set redirect---");
        console.log(event.currentTarget.textContent);
        
        this.setState({
            redirect:true,
            restaurantName:event.currentTarget.textContent
        })
        

    }
    renderRedirect = () => {
        let url = '/restaurant/' + this.state.restaurantName; 
        console.log(url);
        if (this.state.redirect){
            return <Redirect to={url}/>
        }
    }
    constructor(props){
        super(props);    
    }
    render(){
        const {items,isOpen} = this.props;
        if (!isOpen) return null;
        return (
            <div className="popup">
                {this.renderRedirect()}
                <div className="content">
                    { items && items.map((item,idx)=>{
                        return (
                            <div onClick={this.setRedirect} className="item" key={idx}>
                                {item.name}
                            </div>
                        )
                    })}
                    {!items && <div className="warning">Nothing found!</div>}
                </div>

            </div>
        )
    }
}