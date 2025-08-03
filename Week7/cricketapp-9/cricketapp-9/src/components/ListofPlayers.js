import React from 'react';

const ListofPlayers = () => {
  const players = [
    { name: 'Virat Kohli', score: 95 },
    { name: 'Rohit Sharma', score: 88 },
    { name: 'Shubman Gill', score: 67 },
    { name: 'KL Rahul', score: 72 },
    { name: 'Hardik Pandya', score: 56 },
    { name: 'Ravindra Jadeja', score: 60 },
    { name: 'Shreyas Iyer', score: 78 },
    { name: 'Ishan Kishan', score: 45 },
    { name: 'Mohammed Shami', score: 38 },
    { name: 'Bumrah', score: 80 },
    { name: 'Kuldeep Yadav', score: 50 }
  ];
  const lowScoringPlayers = players.filter(player => player.score < 70);

  return (
    <div>
      <h2>All Players:</h2>
      <ul>
        {players.map((player, index) => (
          <li key={index}>
            {player.name} - Score: {player.score}
          </li>
        ))}
      </ul>

      <h3>Players with score below 70:</h3>
      <ul>
        {lowScoringPlayers.map((player, index) => (
          <li key={index}>
            {player.name} - Score: {player.score}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ListofPlayers;
