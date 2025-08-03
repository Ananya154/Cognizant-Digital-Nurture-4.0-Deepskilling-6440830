import React from 'react';
import CohortDetails from './CohortDetails';
import { CohortData } from './Cohort';

function App() {
  const sampleCohort = CohortData[0];

  return (
    <div className="App">
      <h2>Cohort Information</h2>
      <CohortDetails cohort={sampleCohort} />
    </div>
  );
}

export default App;
