import React, { useContext } from 'react';
import ThemeContext from '../ThemeContext';

const EmployeeCard = ({ name, position }) => {
  const theme = useContext(ThemeContext);
  console.log("Current theme:", theme); 

  return (
    <div style={{ margin: '10px 0' }}>
      <h3>{name}</h3>
      <p>{position}</p>
      <button className={theme === 'dark' ? 'dark-btn' : 'light-btn'}>
        View Profile
      </button>
    </div>
  );
};

export default EmployeeCard;
