import '../App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Header from '../user-components/commons/Header';
import Footer from '../user-components/commons/Footer';
import Home from '../user-components/home/Home';
import Login from '../user-components/auth/Login';
import Register from '../user-components/auth/Register';
import BookDetails from '../user-components/book/BookDetails';
import Cart from '../user-components/cart/Cart';
import { useReducer } from 'react';
import { CartReducer } from '../configs/Reducers';
import { CartContext } from '../configs/Contexts';

function UserRoutes() {
  const [quantityInCart, dispatch] = useReducer(CartReducer, 0);

  return (
    <BrowserRouter>
      <CartContext.Provider value={{ quantityInCart, dispatch }}>
        <Header />
        <Routes>
          <Route path='/' element={<Home />} />
          <Route path='/login' element={<Login />} />
          <Route path='/register' element={<Register />} />
          <Route path='/books/:bookId' element={<BookDetails />} />
          <Route path='/cart' element={<Cart />} />
        </Routes>
        <Footer />
      </CartContext.Provider>
    </BrowserRouter>
  );
}

export default UserRoutes;
