import axios from "axios";
import cookie from "react-cookies";

const BASE_URL = 'http://localhost:8080/dbook/';

export const endpoints = {
    'books': '/books',
    'book-details': (bookId) => `/books/${bookId}`,
    'categories': '/categories',
    'receipts': '/receipts',

    'register': '/api/users/',
    'login': '/api/login/',
    'current-user': '/api/current-user/',
    
    'banners': '/banners',
}

console.info(cookie.load('token'))

// export const authApi = () => {
//     return axios.create({
//         baseURL: BASE_URL,
//         headers: {
//             'Authorization': cookie.load('token')
//         }
//     })
// }

export default axios.create({
    baseURL: BASE_URL
});