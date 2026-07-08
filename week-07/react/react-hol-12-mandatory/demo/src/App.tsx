import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from './assets/vite.svg'
import heroImg from './assets/hero.png'
import './App.css'

function SignInPage(props){
  return (
    <div className="App">
      <h1>Sign In</h1>
      <button onClick={props.signIn}>Sign In</button>
    </div>
  )
}

function GreetingPage(props){
  return (
    <div className="App">
      <h1>Welcome!</h1>
      <button onClick={props.signOut}>Sign Out</button>
    </div>
  )
}

function App() {
  const [isLogedIn, setIsLoggedIn] = useState(false)
  const signIn = () => setIsLoggedIn(true)
  const signOut = () => setIsLoggedIn(false)

  return (
    <div className="App">
      {isLogedIn ? (
        <GreetingPage signOut={signOut} />
      ) : (
        <SignInPage signIn={signIn} />
      )}
    </div>
  )
}

export default App
