import React from 'react'
import ReactDOM from 'react-dom'
import { shallow } from 'enzyme'
import App from '../App'
import StrandList from '../StrandList'

it('renders without crashing', () => {
   const div = document.createElement('div')
   ReactDOM.render(<App />, div)
   ReactDOM.unmountComponentAtNode(div)
})

it('contains a StrandList', () => {
   const wrapper = shallow(<App />)
   expect(wrapper.find(StrandList).length).toBe(1)
})
