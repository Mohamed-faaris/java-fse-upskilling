
import './App.css'
import { Comp0 } from './Comp0'
import { Comp1 } from './Comp1'
import { Comp2 } from './Comp2'
import { ScoreCard } from './ScoreCard'

function App() {

  return (
    <>
  <h1>Welcome to React Lab!</h1>
  <p>This is a simple React application to get you started with React development.</p>
  <Comp0 />
  <Comp1 />
  <Comp2 />
  <ScoreCard name="faaris" score={80} maxScore={100} />
    </>
  )
}

export default App
