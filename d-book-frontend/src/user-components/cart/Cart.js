import React, { useState, useEffect, useContext } from 'react';
import { Container, Table, Button, Form, Card, Image, Row, Col } from 'react-bootstrap';
import { formatCurrency } from '../../utils/currencyUtils';
import cookie from "react-cookies";
import './CartStyle.css';
import { IoTrashOutline } from 'react-icons/io5';
import { CartContext } from '../../configs/Contexts';
import { Checkbox } from '@mui/material';
import APIs, { endpoints } from '../../configs/APIs';

const Cart = () => {
  const { dispatch } = useContext(CartContext);
  const [cart, setCart] = useState(cookie.load('cart') || {});
  const [totalPrice, setTotalPrice] = useState(0);
  const [selectedItems, setSelectedItems] = useState({});
  const [selectedTotalPrice, setSelectedTotalPrice] = useState(0); // New state for selected items total price

  // State for customer information
  const [customerName, setCustomerName] = useState('');
  const [customerPhone, setCustomerPhone] = useState('');
  const [customerEmail, setCustomerEmail] = useState('');
  const [customerAddress, setCustomerAddress] = useState('');

  // Mock user ID and payment method ID
  const userId = "1"; // Example user ID
  const paymentMethodId = "1"; // Example payment method ID

  useEffect(() => {
    const calculateTotalPrice = () => {
      const total = Object.values(cart).reduce((acc, item) => acc + item.price * item.quantity, 0);
      setTotalPrice(total);
    };
    calculateTotalPrice();
  }, [cart]);

  useEffect(() => {
    const calculateSelectedTotalPrice = () => {
      const total = Object.keys(selectedItems)
        .filter(id => selectedItems[id]) // Only consider selected items
        .reduce((acc, id) => acc + (cart[id].price * cart[id].quantity), 0);
      setSelectedTotalPrice(total);
    };
    calculateSelectedTotalPrice();
  }, [selectedItems, cart]);

  const handleQuantityChange = (id, quantity) => {
    const newQuantity = Math.max(1, quantity);

    setCart(prevCart => ({
      ...prevCart,
      [id]: { ...prevCart[id], quantity: newQuantity }
    }));

    cookie.save('cart', { ...cart, [id]: { ...cart[id], quantity: newQuantity } });
    updateCart();
  };

  const updateCart = () => {
    dispatch({
      type: 'updateCart',
      payload: countCart()
    });
  };

  const countCart = () => {
    let count = 0;
    let cart = cookie.load("cart") || {};

    for (let c of Object.values(cart)) {
      count += c.quantity;
    }

    return count;
  };

  const handleRemoveFromCart = (id) => {
    const newCart = { ...cart };
    delete newCart[id];
    setCart(newCart);
    cookie.save('cart', newCart);
    updateCart();
  };

  const handleClearCart = () => {
    setCart({});
    cookie.remove('cart');
    updateCart();
  };

  const handleSelectItem = (id) => {
    setSelectedItems(prevSelected => ({
      ...prevSelected,
      [id]: !prevSelected[id]
    }));
  };

  const placeOrder = () => {
    const itemsToOrder = Object.keys(selectedItems)
      .filter(id => selectedItems[id])
      .map(id => ({
        bookId: id,
        quantity: cart[id].quantity,
        unitPrice: cart[id].price // Include unit price
      }));

    if (itemsToOrder.length === 0) {
      alert('Bạn chưa chọn sách nào để đặt hàng!');
      return;
    }

    const totalOrderPrice = itemsToOrder.reduce((sum, item) => sum + item.unitPrice * item.quantity, 0);

    const orderPayload = {
      totalPrice: totalOrderPrice, // Add total price
      customerName: customerName,
      customerPhone: customerPhone,
      customerEmail: customerEmail,
      customerAddress: customerAddress,
      paymentMethodId: paymentMethodId,
      // userId: userId,
      detailsRequests: itemsToOrder // Include the details requests
    };

    // Send order to backend
    APIs.post(endpoints['receipts'], orderPayload)
      .then(response => {
        alert('Đặt hàng thành công!');
        handleClearSelectedItems();
      })
      .catch(error => {
        console.error('Error placing order:', error);
        alert('Đặt hàng thất bại. Vui lòng thử lại!');
      });
  };

  const handleClearSelectedItems = () => {
    // Create a copy of the current cart
    const newCart = { ...cart };

    // Remove selected items
    Object.keys(selectedItems).forEach(id => {
      if (selectedItems[id]) {
        delete newCart[id]; // Remove selected item
      }
    });

    // Update the cart
    setCart(newCart);
    cookie.save('cart', newCart); // Save cart to cookie
    updateCart(); // Update cart count
  };

  return (
    <Container className="py-5">
      {Object.keys(cart).length === 0 ? (
        <h2 className="text-center">Bạn chưa thêm sách nào vào giỏ!</h2>
      ) : (
        <>
          <h2 className="mb-4 text-center">Giỏ hàng của bạn</h2>
          <Row>
            <Col md={8}>
              <Card className="border-0 shadow-lg p-4 mb-5 bg-white rounded">
                <Table hover responsive>
                  <thead>
                    <tr>
                      <th className='col-1'></th>
                      <th className='col-1'></th>
                      <th className='col-3'>Tên sách</th>
                      <th className='col-1'>Giá</th>
                      <th className='col-1'>Số lượng</th>
                      <th className='col-1'></th>
                    </tr>
                  </thead>

                  <tbody>
                    {Object.values(cart).map(book => (
                      <tr key={book.id}>
                        <td>
                          <Checkbox
                            checked={selectedItems[book.id] || false}
                            onChange={() => handleSelectItem(book.id)}
                          />
                        </td>
                        <td>
                          <Image src={book.image} height='120px' thumbnail />
                        </td>
                        <td>{book.title}</td>
                        <td>{formatCurrency(book.price)}</td>
                        <td>
                          <Form.Control
                            type="number"
                            value={book.quantity}
                            min={1}
                            className="text-center"
                            onChange={(e) => handleQuantityChange(book.id, parseInt(e.target.value))}
                          />
                        </td>
                        <td>
                          <Button variant="outline-danger" onClick={() => handleRemoveFromCart(book.id)}>
                            <IoTrashOutline />
                          </Button>
                        </td>
                      </tr>
                    ))}
                  </tbody>
                </Table>
                <div className="d-flex justify-content-between align-items-center px-4 py-3">
                  <Button variant="outline-danger" onClick={handleClearCart}>Xóa tất cả</Button>
                </div>
              </Card>
            </Col>
            <Col md={4}>
              <Card className="border-0 shadow-lg p-4 mb-5 bg-white rounded">
                <h4>Thông tin khách hàng</h4>
                <Form>
                  <Form.Group controlId="customerName">
                    <Form.Label>Tên Khách Hàng</Form.Label>
                    <Form.Control
                      type="text"
                      placeholder="Nhập tên khách hàng"
                      value={customerName}
                      onChange={(e) => setCustomerName(e.target.value)}
                    />
                  </Form.Group>
                  <Form.Group controlId="customerPhone">
                    <Form.Label>Số Điện Thoại</Form.Label>
                    <Form.Control
                      type="text"
                      placeholder="Nhập số điện thoại"
                      value={customerPhone}
                      onChange={(e) => setCustomerPhone(e.target.value)}
                    />
                  </Form.Group>
                  <Form.Group controlId="customerEmail">
                    <Form.Label>Email</Form.Label>
                    <Form.Control
                      type="email"
                      placeholder="Nhập email"
                      value={customerEmail}
                      onChange={(e) => setCustomerEmail(e.target.value)}
                    />
                  </Form.Group>
                  <Form.Group controlId="customerAddress">
                    <Form.Label>Địa Chỉ</Form.Label>
                    <Form.Control
                      type="text"
                      placeholder="Nhập địa chỉ"
                      value={customerAddress}
                      onChange={(e) => setCustomerAddress(e.target.value)}
                    />
                  </Form.Group>
                  <h5>Tổng tiền: {formatCurrency(selectedTotalPrice)}</h5> {/* Display selected total */}
                  <Button variant="primary" className="mt-3" onClick={placeOrder}>Đặt hàng</Button>
                </Form>
              </Card>
            </Col>
          </Row>
        </>
      )}
    </Container>
  );
};

export default Cart;
