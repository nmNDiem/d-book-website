import React, { useEffect, useState } from 'react';
import { Container, Row, Col } from 'react-bootstrap';
import Banner from '../banner/Banner';
import BookItem from '../book/BookCard';
import APIs, { endpoints } from '../../configs/APIs';

const Home = () => {
  const [books, setBooks] = useState([]);

  const loadBooks = async () => {
    try {
      let res = await APIs.get(endpoints['books']);
      setBooks(res.data);
    } catch (ex) {
      console.error(ex);
    }
  }

  useEffect(() => {
    loadBooks();
  }, []);


  return (
    <>
    <Banner />
    <Container className='mb-4'>
      

      <h2 className='mt-4 mb-2'>Đang giảm giá</h2>
      <Row className="g-1 product-slider">
        {books.map((book) => (
          <Col key={book.id} md={2}>
            <BookItem book={book} className="product"/>
          </Col>
        ))}
      </Row>

      <h2 className='mt-4 mb-2'>Sách bán chạy</h2>
      <Row className="g-4">
        {books.map((book) => (
          <Col key={book.id} md={2}>
            <BookItem book={book}/>
          </Col>
        ))}
      </Row>

      <h2 className='mt-4 mb-2'>Sách mới</h2>
      <Row className="g-4">
        {books.map((book) => (
          <Col key={book.id} md={2}>
            <BookItem book={book}/>
          </Col>
        ))}
      </Row>

      <h2 className='mt-4 mb-2'>Tất cả các sách</h2>
      <Row className="g-4">
        {books.map((book) => (
          <Col key={book.id} md={2}>
            <BookItem book={book}/>
          </Col>
        ))}
      </Row>
    </Container>
    </>
  );
};

export default Home;
