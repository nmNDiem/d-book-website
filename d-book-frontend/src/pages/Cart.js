import React, { useState, useEffect, useContext } from 'react';
import { Container, Table, Button, Form, Alert, Card, Image } from 'react-bootstrap';
import { formatCurrency } from '../utils/currencyUtils';
import cookie from "react-cookies";
import './CartStyle.css';
import { IoTrashOutline } from 'react-icons/io5';
import { CartContext } from '../configs/Contexts';

const Cart = () => {
  const {quantityInCart, dispatch} = useContext(CartContext);
  const [cart, setCart] = useState(cookie.load('cart') || null);
  const [totalPrice, setTotalPrice] = useState(0);

  useEffect(() => {
    const calculateTotalPrice = () => {
      const total = Object.values(cart).reduce((acc, item) => acc + item.price * item.quantity, 0);
      setTotalPrice(total);
    };
    calculateTotalPrice();
  }, [cart]);

  const handleQuantityChange = (id, quantity) => {
    const newQuantity = Math.max(1, quantity);

    // Cập nhật giỏ hàng cục bộ
    setCart(prevCart => ({
        ...prevCart,
        [id]: { ...prevCart[id], quantity: newQuantity }
    }));

    // Cập nhật cookie
    cookie.save('cart', { ...cart, [id]: { ...cart[id], quantity: newQuantity } });

    dispatch({
        type: 'updateQuantity', 
        payload: { id, quantity: newQuantity }
    });
};

  const handleRemoveFromCart = (id) => {
    const newCart = { ...cart };
    delete newCart[id];
    setCart(newCart);
    cookie.save('cart', newCart);
  };

  const handleClearCart = () => {
    setCart({});
    cookie.remove('cart');
  };

  return (
    <Container className="py-5">
      {cart === 0 ? (
        <h2 className="text-center">Bạn chưa thêm sách nào vào giỏ!</h2>
      ) : (
        <>
          <h2 className="mb-4 text-center">Giỏ hàng của bạn</h2>
          <Card className="border-0">
            <Table border-0 hover responsive className=" text-center">
              <thead className='table-header'>
                <tr>
                  <th className='col-2 table-header'></th>
                  <th className='col-3'>Tên sách</th>
                  <th className='col-1'>Số lượng</th>
                  <th className='col-3'>Giá</th>
                  <th className='col-2'>Tổng</th>
                  <th className='col-1'></th>
                </tr>
              </thead>
              <tbody>
                {Object.values(cart).map(book => (
                  <tr key={book.id}>
                    <td>
                      <Image src={book.image} height='120px' />
                    </td>
                    <td>{book.title}</td>
                    <td>
                      <Form.Control
                        type="number"
                        value={book.quantity}
                        min={1}
                        className="text-center"
                        onChange={(e) => handleQuantityChange(book.id, parseInt(e.target.value))}
                      />
                    </td>
                    <td>{formatCurrency(book.price)}</td>
                    <td>{formatCurrency(book.price * book.quantity)}</td>
                    <td>
                      <Button variant="outline-danger" 
                      onClick={() => handleRemoveFromCart(book.id)}
                      >
                        <IoTrashOutline />
                      </Button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </Table>
            <div className="d-flex justify-content-between align-items-center px-4 py-3">
              <h3>Tổng tiền: {formatCurrency(totalPrice)}</h3>
              <div>
                <Button variant="primary" className="me-4">Thanh toán</Button>
                <Button variant="outline-danger"
                 onClick={handleClearCart}
                 >Xóa tất cả</Button>
              </div>
            </div>
          </Card>
        </>
      )}
    </Container>
  );
};

export default Cart;
