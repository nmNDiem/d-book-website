import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Header from './components/commons/Header';
import Footer from './components/commons/Footer';
import { Container } from 'react-bootstrap';
// import Home from './pages/Home';
import Login from './pages/Login';
import Register from './pages/Register';
import BookDetails from './pages/BookDetails';
import Cart from './pages/Cart';
import { useReducer } from 'react';
import { CartReducer } from './configs/Reducers';
import { CartContext } from './configs/Contexts';

function App() {
  const [quantityInCart, dispatch] = useReducer(CartReducer, 0);

  return (
    <BrowserRouter>
      <CartContext.Provider value={{quantityInCart, dispatch}}>
        <Header />
        {/* <Container> */}
          <Routes>
            <Route path='/' element={<Home />} />
            <Route path='/login' element={<Login />} />
            <Route path='/register' element={<Register />} />
            <Route path='/books/:bookId' element={<BookDetails />} />
            <Route path='/cart' element={<Cart />} />
          </Routes>
        {/* </Container> */}
        <Footer />
        </CartContext.Provider>
    </BrowserRouter>
  );
}

export default App;
