import React from 'react';
import EmployeeCard from './EmployeeCard';

const EmployeesList = () => {
  const employees = [
    { id: 1, name: 'Ananya', position: 'Frontend Developer' },
    { id: 2, name: 'Rahul', position: 'Backend Developer' }
  ];

  return (
    <div>
      {employees.map(emp => (
        <EmployeeCard key={emp.id} name={emp.name} position={emp.position} />
      ))}
    </div>
  );
};

export default EmployeesList;
