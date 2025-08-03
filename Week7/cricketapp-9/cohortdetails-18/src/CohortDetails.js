import React from 'react';

function CohortDetails({ cohort }) {
  if (!cohort) {
    return <div>No cohort data available</div>;
  }

  return (
    <div>
      <h3>{cohort.code}</h3>
      <p>Name: {cohort.name}</p>
      <p>Status: {cohort.status}</p>
    </div>
  );
}

export default CohortDetails;
