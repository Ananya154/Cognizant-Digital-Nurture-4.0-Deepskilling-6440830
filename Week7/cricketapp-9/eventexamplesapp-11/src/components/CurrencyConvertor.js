import React, { Component } from 'react';

class CurrencyConvertor extends Component {
  constructor(props) {
    super(props);
    this.state = {
      rupees: '',
      euro: ''
    };
  }

  handleChange = (e) => {
    this.setState({ rupees: e.target.value });
  };

  handleSubmit = () => {
    const euroValue = (this.state.rupees / 90).toFixed(2); // Example rate: ₹90 = €1
    this.setState({ euro: euroValue });
  };

  render() {
    return (
      <div>
        <h2>Currency Convertor (INR ➡️ Euro)</h2>
        <input
          type="number"
          placeholder="Enter amount in INR"
          value={this.state.rupees}
          onChange={this.handleChange}
        />
        <button onClick={this.handleSubmit}>Convert</button>
        <p>Equivalent in Euro: €{this.state.euro}</p>
      </div>
    );
  }
}

export default CurrencyConvertor;
