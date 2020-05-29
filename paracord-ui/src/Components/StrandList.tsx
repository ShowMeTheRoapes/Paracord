import React from 'react'
import Strand from '../Components/Strand'
import { Container, Col, Row } from 'reactstrap'

const StrandList: React.FunctionComponent = () => {
  return (
    <Container>
      <Row className="text-center">
        <Col>
          <Strand name="Strand1" />
        </Col>
        <Col>
          <Strand name="Strand2" />
        </Col>
        <Col>
          <Strand name="Strand3" />
        </Col>
      </Row>
    </Container>
  )
}

export default StrandList
