import React, { Component } from 'react';
import Cart from './Cart';

class OnlineShopping extends Component {
  render() {
    const items = [
      { itemname: "Laptop", price: 50000 },
      { itemname: "Headphones", price: 2000 },
      { itemname: "Keyboard", price: 1500 },
      { itemname: "Mouse", price: 800 },
      { itemname: "Monitor", price: 12000 }
    ];

    return (
      <div>
        <h2>Online Shopping Cart</h2>
        {items.map((item, index) => (
          <Cart key={index} itemname={item.itemname} price={item.price} />
        ))}
      </div>
    );
  }
}

export default OnlineShopping;
