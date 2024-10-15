import React from 'react';
import { Admin, Resource } from 'react-admin';
import dataProvider from './dataProvider';
import { CategoryCreate } from './components/categories/CategoryCreate';
import BookList from './components/books/BookList';
import BookEdit from './components/books/BookEdit';
import BookCreate from './components/books/BookCreate';
import UserList from './components/users/UserList';
import UserEdit from './components/users/UserEdit';
import UserCreate from './components/users/UserCreate';
import PublisherList from './components/publishers/PublisherList';
import PublisherEdit from './components/publishers/PublisherEdit';
import PublisherCreate from './components/publishers/PublisherCreate';
import PaymentMethodList from './components/payment-methods/PaymentMethodList';
import PaymentMethodEdit from './components/payment-methods/PaymentMethodEdit';
import PaymentMethodCreate from './components/payment-methods/PaymentMethodCreate';
import AuthorList from './components/authors/AuthorList';
import AuthorEdit from './components/authors/AuthorEdit';
import AuthorCreate from './components/authors/AuthorCreate';
import { CategoryList } from './components/categories/CategoryList';
import { CategoryEdit } from './components/categories/CategoryEdit';
import { FaBuilding, FaUserGroup, FaUserPen } from 'react-icons/fa6';
import { ImBooks } from 'react-icons/im';
import { MdPayment } from 'react-icons/md';

const AdminDashboard = () => {
    return (
        <Admin basename="/admin" dataProvider={dataProvider}>
            <Resource name="books" icon={ImBooks} list={BookList} edit={BookEdit} create={BookCreate} />
            <Resource name="categories" list={CategoryList} edit={CategoryEdit} create={CategoryCreate} />
            <Resource name="authors" icon={FaUserPen} list={AuthorList} edit={AuthorEdit} create={AuthorCreate} />
            <Resource name="publishers" icon={FaBuilding} list={PublisherList} edit={PublisherEdit} create={PublisherCreate} />
            <Resource name="paymentMethods" icon={MdPayment} list={PaymentMethodList} edit={PaymentMethodEdit} create={PaymentMethodCreate} />
            <Resource name="users" icon={FaUserGroup} list={UserList} edit={UserEdit} create={UserCreate} />
        </Admin>
    );
};

export default AdminDashboard;