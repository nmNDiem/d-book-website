// Header.js
import React, { useContext } from 'react';
import { Navbar, Nav, NavDropdown, Form, Button, Badge, Container } from 'react-bootstrap';
import { FaShoppingCart, FaUser } from 'react-icons/fa';
import './HeaderStyle.css';
import { Link } from 'react-router-dom';
import { CartContext } from '../../configs/Contexts';

const Header = () => {
  const { quantityInCart, dispatch } = useContext(CartContext);

  return (
    <Navbar bg="light" expand="lg" sticky="top" className='shadow'>
      <Container>
        <Navbar.Brand as={Link} to={"/"}>
          <img src="/ic_Dbook5.png" alt="Logo" style={{ height: '50px' }} />
        </Navbar.Brand>

        <Navbar.Toggle aria-controls="navbarScroll" />
        <Navbar.Collapse id="navbarScroll">
          <Nav className="me-auto my-2 my-lg-0" navbarScroll>
            <Nav.Link as={Link} to={"/"}>Trang chủ</Nav.Link>
            <NavDropdown title="Danh mục sách" id="navbarScrollingDropdown" className="hover-dropdown">
              <NavDropdown.Item href="/category/science">Khoa học</NavDropdown.Item>
              <NavDropdown.Item href="/category/literature">Văn học</NavDropdown.Item>
              <NavDropdown.Item href="/category/business">Kinh doanh</NavDropdown.Item>
              <NavDropdown.Divider />
              <NavDropdown.Item href="/category/all">Tất cả danh mục</NavDropdown.Item>
            </NavDropdown>
          </Nav>

          <Form className="d-flex d mx-4">
            <Form.Control type="search" placeholder="Search" className="me-2" aria-label="Search" />
            <Button variant="outline-success">Search</Button>
          </Form>

          <Nav.Link as={Link} to="/cart" className='mx-3'>
            <FaShoppingCart size={24} />
            <Badge pill bg="danger" className="ms-1">
              {quantityInCart}
            </Badge>
          </Nav.Link>

          <Nav.Link href="/profile" className='me-2'>
            <FaUser size={24} />
          </Nav.Link>

          {/* <Nav>
            <Button variant="outline-primary" className='me-2'>Đăng nhập</Button>
            <Button variant="primary">Đăng ký</Button>
          </Nav> */}
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
};

export default Header;
