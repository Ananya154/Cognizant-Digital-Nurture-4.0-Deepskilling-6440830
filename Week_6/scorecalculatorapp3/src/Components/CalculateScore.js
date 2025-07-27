import React from 'react';
import '../Stylesheets/mystyle.css';

function CalculateScore(props) {
  const avg = props.total / props.goal;
  
  return (
    <div className="container">
      <h2 className="title">Student Score Report</h2>
      <p><strong>Name:</strong> {props.name}</p>
      <p><strong>School:</strong> {props.school}</p>
      <p><strong>Total Marks:</strong> {props.total}</p>
      <p><strong>Goal:</strong> {props.goal}</p>
      <p><strong>Average Score:</strong> {avg}</p>
    </div>
  );
}

export default CalculateScore;
