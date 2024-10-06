import React from 'react';
import { Table, Button } from 'react-bootstrap';
import { useCart } from '../../context/CartContext'; 
import { formatCurrency } from '../../utils/currencyUtils';

const CartItem = ({ item }) => {
  const { dispatch } = useCart();

  const handleRemove = () => {
    dispatch({ type: 'REMOVE_FROM_CART', payload: item.book.id }); 
  };

  return (
    <Table striped bordered hover className="mt-3">
      <thead>
        <tr>
          <th>Tên sách</th>
          <th>Số lượng</th>
          <th>Giá</th>
          <th>Thao tác</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>{item.book.title}</td>
          <td>{item.quantity}</td>
          <td>{formatCurrency(item.book.price * item.quantity)}</td>
          <td>
            <Button variant="danger" onClick={handleRemove}>Xóa</Button>
          </td>
        </tr>
      </tbody>
    </Table>
  );
};

export default CartItem;
