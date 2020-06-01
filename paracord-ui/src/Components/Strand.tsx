import React from 'react'
import { Button } from 'reactstrap'

interface Props {
  name: string
}

const Strand: React.FunctionComponent<Props> = (props: Props) => {
  return (
    <Button color="primary" className="strand-button hover:shadow-up">
      {props.name}
    </Button>
  )
}

export default Strand
