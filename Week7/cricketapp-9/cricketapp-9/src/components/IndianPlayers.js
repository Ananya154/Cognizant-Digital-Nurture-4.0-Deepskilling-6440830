import React from 'react';

const IndianPlayers = () => {
  const oddTeam = ['Virat', 'Gill', 'KL Rahul', 'Jadeja', 'Shreyas'];
  const evenTeam = ['Rohit', 'Hardik', 'Ishan', 'Shami', 'Bumrah'];

  //  Destructuring the first two from odd and even teams
  const [odd1, odd2, ...restOdd] = oddTeam;
  const [even1, even2, ...restEven] = evenTeam;

  //  Merge two arrays using spread operator
  const T20players = ['Surya', 'Rinku'];
  const RanjiTrophyPlayers = ['Pujara', 'Rahane'];
  const mergedPlayers = [...T20players, ...RanjiTrophyPlayers];

  return (
    <div>
      <h2>Odd Team Players (Destructured):</h2>
      <ul>
        <li>{odd1}</li>
        <li>{odd2}</li>
        {restOdd.map((player, i) => (
          <li key={i + 2}>{player}</li>
        ))}
      </ul>

      <h2>Even Team Players (Destructured):</h2>
      <ul>
        <li>{even1}</li>
        <li>{even2}</li>
        {restEven.map((player, i) => (
          <li key={i + 2}>{player}</li>
        ))}
      </ul>

      <h2>Merged Players (T20 + Ranji):</h2>
      <ul>
        {mergedPlayers.map((player, index) => (
          <li key={index}>{player}</li>
        ))}
      </ul>
    </div>
  );
};

export default IndianPlayers;