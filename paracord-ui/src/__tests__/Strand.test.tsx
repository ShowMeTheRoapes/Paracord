import React from 'react'
import { shallow } from 'enzyme'
import Strand from '../Components/Strand'

it('contains a the passed in name', () => {
   const wrapper = shallow(<Strand name='Test' />)
   expect(wrapper.contains('Test')).toBe(true)
})
