import React from 'react'
import { shallow } from 'enzyme'
import Strand from '../Components/Strand'

it('contains a paragraph', () => {
   const wrapper = shallow(<Strand />)
   expect(wrapper.contains(<p>Strand</p>)).toBe(true)
})
