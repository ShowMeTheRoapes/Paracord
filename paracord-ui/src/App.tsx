import React from 'react'
import './generated/tailwind.css'
import StrandList from './Components/StrandList'

const App: React.FunctionComponent<{}> = () => {
  return (
    <div className="flex">
      <div className="w-1/6 bg-gray-500" />
      <div className="w-4/6 bg-gray-500">
        <StrandList />
      </div>
      <div className="w-1/6 bg-gray-500" />
    </div>
  )
}

export default App
