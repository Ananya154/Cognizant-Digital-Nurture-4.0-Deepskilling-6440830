import React, { Component } from 'react';
import CurrencyConvertor from './components/CurrencyConvertor';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      count: 0,
      message: ''
    };
  }

  increment = () => {
    this.setState(prevState => ({ count: prevState.count + 1 }));
  };

  decrement = () => {
    this.setState(prevState => ({ count: prevState.count - 1 }));
  };

  sayHello = () => {
    this.setState({ message: 'Hello! This is a static message.' });
  };

  handleIncrease = () => {
    this.increment();
    this.sayHello();
  };

  sayWelcome = (msg) => {
    alert(`You said: ${msg}`);
  };

  handleSyntheticEvent = (event) => {
    alert("I was clicked");
  };

  render() {
    return (
      <div style={{ padding: '20px', fontFamily: 'Arial' }}>
        <h1>React Event Handling Example</h1>

        <h2>Counter: {this.state.count}</h2>
        <button onClick={this.increment}>Increment</button>
        <button onClick={this.decrement}>Decrement</button>

        <br /><br />

        <button onClick={this.handleIncrease}>Increase (Multiple Methods)</button>
        <p>{this.state.message}</p>

        <br />

        <button onClick={() => this.sayWelcome("welcome")}>Say Welcome</button>

        <br /><br />

        <button onClick={this.handleSyntheticEvent}>Synthetic Event OnPress</button>

        <br /><br />

        <CurrencyConvertor />
      </div>
    );
  }
}

export default App;
