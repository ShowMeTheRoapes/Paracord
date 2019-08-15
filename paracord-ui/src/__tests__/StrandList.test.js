import React from 'react'
import { shallow } from 'enzyme'
import StrandList from '../Components/StrandList'
import Strand from '../Components/Strand'

it('contains 3 Strands', () => {
   const wrapper = shallow(<StrandList />)
   expect(wrapper.find(Strand).length).toBe(3)
})
