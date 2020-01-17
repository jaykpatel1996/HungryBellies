import React from "react";
const Product = ({ createdAt, cuisine,description,id,imgUrl, itemName,price,quantity,rating,addFunc}) => {
    console.log("id is")
    console.log(id);
    return (
        <article class="w-30 bg-white br3 pa3 pa4-ns mv3 ba b--black-10" id={id}>
            <div class="tc">
                <img src={imgUrl} height="100px" width="100px" class="br-100 h4 w4 dib ba b--black-05 pa2" title={itemName} />
                <h1 class="f3 mb2">{itemName}</h1>
                <h2 class="f5 fw4 gray mt0">{description}</h2>
                <button className="f6 link dim br1 ba bw1 ph3 pv2 mb2 dib dark-green"
                   onClick={()=> addFunc({id,itemName,description,imgUrl,price,units:1})}
                > Add</button>
                <span>${price}</span>
            </div>
        </article>
    );
};

export default Product;