import React, { useContext } from 'react';
import { Alert, Button, Card } from 'react-bootstrap';
import './BookCardStyle.css';
import { useNavigate } from 'react-router-dom';
import { formatCurrency } from '../../utils/currencyUtils';
import { FaCartPlus } from 'react-icons/fa';
import { CartContext } from '../../configs/Contexts';
import cookie from "react-cookies";

const BookItem = ({ book }) => {
    const { quantityInCart, dispatch } = useContext(CartContext);
    const navigate = useNavigate();

    const addToCart = (book) => {
        let cart = cookie.load("cart") || null;
        if (cart === null)
            cart = {};

        if (book.id in cart) {
            // có trong giỏ, tăng số lượng
            cart[book.id]["quantity"]++;
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
        updateCart();
    }


    const updateCart = () => {
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

    const goToBookDetails = (id) => {
        navigate(`/books/${id}`);
    };

    return (
        <Card className="book-card" onClick={() => goToBookDetails(book.id)}>
            <Card.Img
                variant="top"
                src={book.image}
                className="card-img" />

            <Card.Body>
                <Card.Title className="card-title">{book.title}</Card.Title>
                <div className='d-flex justify-content-between'>
                    <Card.Text className="card-text">{formatCurrency(book.price)}</Card.Text>
                    <Button
                        variant="outline-primary"
                        className="shadow"
                        onClick={(e) => {
                            e.stopPropagation(); // Ngăn chặn click lan truyền
                            addToCart(book);
                        }}
                    >
                        <FaCartPlus />
                    </Button>
                </div>
            </Card.Body>
        </Card>
    );
};

export default BookItem;
