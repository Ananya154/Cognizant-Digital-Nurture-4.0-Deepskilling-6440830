import React, { useState } from 'react';
import EmployeesList from './components/EmployeesList';
import ThemeContext from './ThemeContext';

function App() {
  const [theme, setTheme] = useState('dark');

  return (
    <ThemeContext.Provider value={theme}>
      <div className="App">
        <h1>Employee Management</h1>
        <EmployeesList />
      </div>
    </ThemeContext.Provider>
  );
}

export default App;
