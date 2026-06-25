# React Hol 09
<img width="1501" height="872" alt="image" src="https://github.com/user-attachments/assets/1e943ecd-4640-4077-8fee-7139f530268c" />
<img width="1317" height="1050" alt="image" src="https://github.com/user-attachments/assets/a3fcae7f-0dc1-4b30-ae5d-67c936996345" />
<img width="1395" height="944" alt="image" src="https://github.com/user-attachments/assets/337006ee-146b-44f6-9316-0cd35c90145f" />

```ts

import { useState } from 'react';
import './App.css'

type Player = {
  name: string;
  score: number;
};

const t20Players: Player[] = [
  { name: 'Alice', score: 10 },
  { name: 'Bob', score: 20 },
  { name: 'Charlie', score: 15 },
  { name: 'David', score: 25 },
  { name: 'Eve', score: 30 },
]

const ranjithPlayers: Player[] = [
  { name: 'Frank', score: 5 },
  { name: 'Grace', score: 12 },
  { name: 'Heidi', score: 18 },
  { name: 'Ivan', score: 22 },
  { name: 'Judy', score: 28 },

  { name: 'Mallory', score: 8 },
]

const players: Player[] = [...t20Players, ...ranjithPlayers];

const PlayerDisplay = (props: Player) => {
  return (
    <div>
      <h3>{props.name}</h3>
      <p>Score: {props.score}</p>
    </div>
  );
};

const ListOfPlayers = (props: { players: Player[] }) => {
  return (
    <div>
      {props.players.map((player) => PlayerDisplay(player))}
    </div>
  );
};

const PlayerWithLessThan70Display = (props: { players: Player[] }) => {
  const filteredPlayers = props.players.filter((player) => player.score < 70);
  return ListOfPlayers({ players: filteredPlayers });
};

const OddPlayersDisplay = (props: { players: Player[] }) => {
  const [first, , third, , fifth] = props.players;
  return ListOfPlayers({ players: [first, third, fifth] });
}

const EvenPlayersDisplay = (props: { players: Player[] }) => {
  const [, second, , fourth] = props.players;
  return ListOfPlayers({ players: [second, fourth] });
}

const Diplay = (props: { players: Player[], flag: boolean }) => {

  if (props.flag) {
    return (<>
    <h1> all players</h1>
      <ListOfPlayers players={props.players} />
      <h1> players with score less than 70</h1>
      <PlayerWithLessThan70Display players={props.players} />
    </>)
  } else {
    return (<>
      <h1> odd players</h1>
      <OddPlayersDisplay players={props.players} />
      <h1> even players</h1>
      <EvenPlayersDisplay players={props.players} />
    </>)
  }
}



function App() {
  const [isTrue, setIsTrue] = useState(true);
  const toggle = () => {
    setIsTrue((prev) => !prev);
  }
  return (
    <>
      <button onClick={toggle}>{isTrue ? "True" : "False"} </button>
      <Diplay players={players} flag={isTrue} />
    </>
  )
}

export default App

```
## Objectives

List the features of ES6
Explain JavaScript let
Identify the differences between var and let
Explain JavaScript const
Explain ES6 class fundamentals
Explain ES6 class inheritance
Define  ES6 arrow functions
Identify set(), map()

In this hands-on lab, you will learn how to:
Use map() method of ES6
Apply arrow functions of ES6
Implement Destructuring features of ES6
Prerequisites

The following is required to complete this hands-on lab:
Node.js
NPM
Visual Studio Code

Notes

Estimated time to complete this lab: 60 minutes.
Create a React Application named “cricketapp” with the following components:
ListofPlayers
Declare an array with 11 players and store details of their names and scores using the map feature of ES6



Filter the players with scores below 70 using arrow functions of ES6.



IndianPlayers

Display the Odd Team Player and Even Team players using the Destructuring features of ES6


Declare two arrays T20players and RanjiTrophy players and merge the two arrays and display them using the Merge feature of ES6


Display these two components in the same home page using a simple if else in the flag variable.
Output:
When Flag=true


When Flag=false






Hint:
