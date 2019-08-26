import React, { Component } from 'react'
import PropTypes from 'prop-types'

class Strand extends Component {
   render() {
      return (
         <div className='w-1/3 p-2'>
            <div className='max-w-sm rounded overflow-hidden shadow-lg bg-red-400'>
               <div className='px-6 py-4'>
                  <div className='font-bold text-xl mb-2 text-center'>
                     {this.props.name}
                  </div>
               </div>
            </div>
         </div>
      )
   }
}

Strand.propTypes = {
   name: PropTypes.string
}

export default Strand
