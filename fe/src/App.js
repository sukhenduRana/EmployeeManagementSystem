import React, { Component } from 'react';
import './App.css';
import EmployeeApp from '../src/components/employee/EmployeeApp'
import './bootstrap.css'

class App extends Component {
  render() {
    return (
      <div className="App">
        <EmployeeApp/>
      </div>
    );
  }
}

export default App;
