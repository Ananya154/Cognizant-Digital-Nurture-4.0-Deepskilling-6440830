import React, { Component } from 'react';

class Cart extends Component {
  render() {
    return (
      <div>
        <h3>Item: {this.props.itemname}</h3>
        <p>Price: ₹{this.props.price}</p>
      </div>
    );
  }
}
Cart.defaultProps = {
  itemname: "Unknown Item",
  price: 0
};

export default Cart;
