// App.js
import React from 'react';
import CohortDetails from './CohortDetails';

function App() {
  return (
    <div>
      <h2>Cohort Dashboard</h2>
      <CohortDetails
        name="ReactJS June Cohort"
        startDate="2025-06-01"
        endDate="2025-07-31"
        status="ongoing"
      />
      <CohortDetails
        name="Java May Cohort"
        startDate="2025-05-01"
        endDate="2025-06-30"
        status="completed"
      />
    </div>
  );
}

export default App;
