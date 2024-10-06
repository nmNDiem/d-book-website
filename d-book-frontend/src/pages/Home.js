// Home.js
import React, { useEffect, useState } from 'react';
import { Container, Row, Col } from 'react-bootstrap';
import Banner from '../components/banner/Banner';
import BookItem from '../components/book/BookItem';
import APIs, { endpoints } from '../configs/APIs';

// Dữ liệu mẫu cho sách
const booksData = {
  categories: ['Khoa học', 'Văn học', 'Kinh tế', 'Giáo dục'],
  discountedBooks: [
    { title: 'Sách giảm giá 1', price: 100000, discount: 30 },
    { title: 'Sách giảm giá 2', price: 150000, discount: 20 },
  ],
  bestsellers: [
    { title: 'Sách bán chạy 1', price: 120000 },
    { title: 'Sách bán chạy 2', price: 200000 },
  ],
  newBooks: [
    { title: 'Sách mới 1', price: 180000 },
    { title: 'Sách mới 2', price: 220000 },
  ],
  allBooks: [
    { title: 'Sách 1', price: 90000 },
    { title: 'Sách 2', price: 130000 },
    { title: 'Sách 3', price: 110000 },
    { title: 'Sách 2', price: 130000 },
    { title: 'Sách 1', price: 90000 },
    { title: 'Sách 2', price: 130000 },
    { title: 'Sách 3', price: 110000 },
    { title: 'Sách 2', price: 130000 },
    { title: 'Sách 1', price: 90000 },
    { title: 'Sách 2', price: 130000 },
    { title: 'Sách 3', price: 110000 },
    { title: 'Sách 2', price: 130000 }
  ],
};

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
    <Container className='mb-4'>
      <Banner />

      <h2 className='mt-4 mb-2'>Đang giảm giá</h2>
      <Row className="g-1">
        {books.map((book) => (
          <Col key={book.id} md={2}>
            <BookItem book={book}/>
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
  );
};

export default Home;
