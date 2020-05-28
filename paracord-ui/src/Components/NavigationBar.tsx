import React, { FunctionComponent } from 'react'
import { Navbar, NavbarBrand } from 'reactstrap'

const NavigationBar: FunctionComponent<{}> = () => {
  return (
    <Navbar color="dark" dark expand="md">
      <NavbarBrand href="/">Paracord</NavbarBrand>
    </Navbar>
  )
}

export default NavigationBar
