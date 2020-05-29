import React from 'react'
import './css/App.css'
import './generated/tailwind.css'
import NavigationBar from './Components/NavigationBar'
import StrandList from './Components/StrandList'

const App: React.FunctionComponent<{}> = () => {
  return (
    <div>
      <NavigationBar />
      <div className="App">
        <StrandList />
      </div>
    </div>
  )
}

export default App
