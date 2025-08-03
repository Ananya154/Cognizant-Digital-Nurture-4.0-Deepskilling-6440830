import React, { useState } from 'react';

function ComplaintRegister() {
  const [employeeName, setEmployeeName] = useState('');
  const [complaint, setComplaint] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    const referenceNumber = Math.floor(100000 + Math.random() * 900000);
    alert(
      `Complaint submitted successfully!\nReference Number: ${referenceNumber}\nName: ${employeeName}\nComplaint: ${complaint}`
    );
    setEmployeeName('');
    setComplaint('');
  };

  return (
    <div style={{ padding: '20px' }}>
      <h2>Raise a Complaint</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Employee Name:</label><br />
          <input
            type="text"
            value={employeeName}
            onChange={(e) => setEmployeeName(e.target.value)}
            required
            style={{ width: '300px', padding: '5px' }}
          />
        </div>

        <div style={{ marginTop: '10px' }}>
          <label>Complaint:</label><br />
          <textarea
            value={complaint}
            onChange={(e) => setComplaint(e.target.value)}
            required
            rows="4"
            cols="50"
            style={{ padding: '5px' }}
          />
        </div>

        <button type="submit" style={{ marginTop: '10px', padding: '5px 10px' }}>
          Submit
        </button>
      </form>
    </div>
  );
}

export default ComplaintRegister;
