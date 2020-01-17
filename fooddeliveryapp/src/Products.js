import Product from "./Product"

import React from 'react';
export default class Products extends React.PureComponent{

  
    findProductIndex = (cart,productId)=> {
        return cart.findIndex(p => p.id === productId);
    }

    updateProductUnits = (cart,product) => {
        
        const productIndex = this.findProductIndex(cart,product.id);
        
            const updatedProducts = [...cart];
            const existingProduct = updatedProducts[productIndex];
            const updatedUnitsProduct = {
                ...existingProduct,
                units:existingProduct.units + product.units
            }
            updatedProducts[productIndex] = updatedUnitsProduct;
            return updatedProducts;

        
    }


    addToCart = (product) =>{
        const {cart} = this.state;
        const existingProductIndex = this.findProductIndex(cart,product.id);
        this.setState({
            cart: existingProductIndex >=0 ? this.updateProductUnits(cart,product):[...cart,product]
        })
    };
    render(){
        const { products } = this.props;

        return <div className="flex flex-wrap justify-between">
                {
                    products.map(p => (<Product key={p.id} { ...p} addFunc={this.addToCart} />))
                }

        </div>
        


    }
}


