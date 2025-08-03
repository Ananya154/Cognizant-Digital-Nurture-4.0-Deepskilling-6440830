import React, { Component } from 'react';
import Guest from './components/Guest';
import User from './components/User';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      isLoggedIn: false
    };
  }

  login = () => {
    this.setState({ isLoggedIn: true });
  };

  logout = () => {
    this.setState({ isLoggedIn: false });
  };

  render() {
    let content;
    if (this.state.isLoggedIn) {
      content = <User />;
    } else {
      content = <Guest />;
    }

    return (
      <div style={{ padding: '20px', fontFamily: 'Arial' }}>
        <h1> Ticket Booking App</h1>
        
        {/* Login/Logout Buttons */}
        {this.state.isLoggedIn ? (
          <button onClick={this.logout}>Logout</button>
        ) : (
          <button onClick={this.login}>Login</button>
        )}

        <hr />

        {/* Conditional Content */}
        {content}
      </div>
    );
  }
}

export default App;
