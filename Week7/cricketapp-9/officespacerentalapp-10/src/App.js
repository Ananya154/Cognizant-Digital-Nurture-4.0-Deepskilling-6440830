import React from 'react';

function App() {
  const heading = <h1> Office Space Rental App</h1>;

  const officeImage = (
    <img
      src="https://cdn.pixabay.com/photo/2016/11/29/07/05/architecture-1868667_960_720.jpg"
      alt="Office Space"
      width="500"
      style={{ borderRadius: '10px', marginBottom: '20px' }}
    />
  );

  const office = {
    name: 'WorkHub Solutions',
    rent: 55000,
    address: 'Banjara Hills, Hyderabad'
  };

  const officeList = [
    {
      name: 'Startup Hive',
      rent: 45000,
      address: 'Hitech City, Hyderabad'
    },
    {
      name: 'TechNest Pvt Ltd',
      rent: 72000,
      address: 'Kondapur, Hyderabad'
    },
    {
      name: 'InnoSpace',
      rent: 61000,
      address: 'Gachibowli, Hyderabad'
    },
    {
      name: 'WorkHub Solutions',
      rent: 55000,
      address: 'Banjara Hills, Hyderabad'
    }
  ];

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial' }}>
      {heading}
      {officeImage}

      <h2>Featured Office:</h2>
      <p><strong>Name:</strong> {office.name}</p>
      <p><strong>Rent:</strong> ₹{office.rent}</p>
      <p><strong>Address:</strong> {office.address}</p>

      <hr />

      <h2>All Available Office Spaces:</h2>
      <ul>
        {officeList.map((item, index) => (
          <li key={index} style={{ marginBottom: '15px' }}>
            <strong>Name:</strong> {item.name} <br />
            <strong>Rent:</strong>{' '}
            <span
              style={{
                color: item.rent < 60000 ? 'red' : 'green',
                fontWeight: 'bold'
              }}
            >
              ₹{item.rent}
            </span>
            <br />
            <strong>Address:</strong> {item.address}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
