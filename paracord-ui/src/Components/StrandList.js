import React from 'react'
import Strand from '../Components/Strand'

function StrandList() {
   return (
      <div id='strand-list' className='flex content-around flex-wrap h-48'>
         <Strand name='Test' />
         <Strand name='AbcDeF' />
         <Strand name='1234' />
      </div>
   )
}

export default StrandList
