import React from 'react'
import { shallow } from 'enzyme'
import StrandList from '../Components/StrandList'

it('contains a StrandList', () => {
   const wrapper = shallow(<StrandList />)
   expect(wrapper.contains(<p>I will be the strand list one day!</p>)).toBe(true)
})
