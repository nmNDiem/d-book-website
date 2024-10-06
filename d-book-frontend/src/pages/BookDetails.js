import React, { useContext, useEffect, useState } from 'react';
import { Container, Row, Col, Card, Button, Form, Spinner, Badge, Table } from 'react-bootstrap';
import ReactStars from 'react-rating-stars-component';
import { useParams } from 'react-router-dom';
import APIs, { endpoints } from '../configs/APIs';
import { FaCartPlus } from 'react-icons/fa';
import './BookDetailsStyle.css';
import { formatCurrency } from '../utils/currencyUtils';
import cookie from "react-cookies";
import { CartContext } from '../configs/Contexts';

const BookDetails = () => {
  const { bookId } = useParams();
  const [book, setBook] = useState(null);
  const [quantity, setQuantity] = useState(1);
  const {quantityInCart, dispatch} = useContext(CartContext);

  useEffect(() => {
    const loadBookDetail = async () => {
      try {
        let res = await APIs.get(endpoints["book-details"](bookId));
        setBook(res.data);
      } catch (err) {
        console.error(err);
      }
    };

    loadBookDetail();
  }, [bookId]);

  const addToCart = (book) => {
    let cart = cookie.load("cart") || null;
    if (cart === null)
      cart = {};

    if (book.id in cart) {
      // có trong giỏ, tăng số lượng
      cart[book.id]["quantity"] += quantity;
    } else {
      // chưa có trong giỏ, tạo sách mới
      cart[book.id] = {
        "id": book.id,
        "image": book.image,
        "title": book.title,
        "price": book.price,
        "discountPercent": book.discountPercent,
        "quantity": 1
      }
    }

    cookie.save("cart", cart);
    dispatch({
      type: 'updateCart',
      payload: countCart()
    })

  }

  const countCart = () => {
    let count = 0;
    let cart = cookie.load("cart") || null;

    if (cart !== null) {
      for (let c of Object.values(cart))
        count += c.quantity;
    }

    return count;
  }

    const handleQuantityChange = (e) => {
      const value = Math.max(1, e.target.value); // Số lượng phải lớn hơn 0
      setQuantity(value);
    };

  if (!book) {
    return <Spinner animation="border" variant="info" />;
  }

  return (
    <Container>
      <Card className="border-0">
        <Row className="py-5">
          <Col md={5}>
            <Card.Img
              variant="top"
              src={book.image || 'https://via.placeholder.com/300'}
              style={{ height: '300px', objectFit: 'contain' }} />
          </Col>

          <Col md={7}>
            <h2>{book.title}</h2>
            <div>Tác giả: {book.authorName}</div>
            <ReactStars count={5} value={book.rating} size={24} edit={false} activeColor="#ffd700" />

            <h3 className='mt-3'>
              {book.discountPercent > 0 ? (
                <div className="d-flex align-items-end">
                  <span style={{ color: 'OrangeRed' }}>
                    {formatCurrency(book.price - (book.price * book.discountPercent) / 100)}
                  </span>
                  <span style={{ textDecoration: 'line-through', marginInline: '14px', fontSize: '18px', color: 'gray' }}>
                    {formatCurrency(book.price)}
                  </span>
                  <h6>
                    <Badge bg="danger" className="me-2 shadow">
                      -{book.discountPercent}%
                    </Badge>
                  </h6>
                </div>
              ) : (
                <span>{formatCurrency(book.price)}</span>
              )}
            </h3>

            <Form.Group controlId="productQuantity" className="mt-3 d-flex align-items-center">
              <Form.Label>Số lượng:</Form.Label>
              <Form.Control
                type="number"
                min="1"
                value={quantity}
                onChange={handleQuantityChange}
                style={{ width: '90px', marginLeft: '14px' }}
              />
            </Form.Group>

            <div style={{ display: 'flex', gap: '16px', marginTop: '20px' }}>
              <Button variant="outline-primary" className="shadow" onClick={() => addToCart(book)}>
                <FaCartPlus /> Thêm vào giỏ
              </Button>
              <Button variant="primary" className="shadow">
                Mua ngay
              </Button>
            </div>
          </Col>
        </Row>
      </Card>

      {/* Chi tiết sản phẩm */}
      <h4 className="mt-4">Chi tiết sản phẩm</h4>
      <Table className="mt-3 table-row">
        <tbody>
          <tr>
            <td className="col-1 text-secondary">Thể loại</td>
            <td className="col-5">{book.categoryName}</td>
          </tr>
          <tr>
            <td className="text-secondary">ISBN</td>
            <td>{book.isbn}</td>
          </tr>
          <tr>
            <td className="text-secondary">Nhà xuất bản</td>
            <td>{book.publisherName}</td>
          </tr>
          <tr>
            <td className="text-secondary">Năm xuất bản</td>
            <td>{book.publishedYear}</td>
          </tr>
          <tr>
            <td className="text-secondary">Mô tả</td>
            <td>{book.description}</td>
          </tr>
        </tbody>
      </Table>
    </Container>
  );
};

export default BookDetails;
