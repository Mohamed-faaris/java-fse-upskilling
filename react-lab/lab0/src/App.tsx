
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
