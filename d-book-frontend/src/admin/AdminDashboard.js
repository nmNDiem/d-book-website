import React from 'react';
import { Admin, Resource } from 'react-admin';
import dataProvider from './dataProvider';
import { CategoryList } from './components/categories/CategoryList';
import { CategoryEdit } from './components/categories/CategoryEdit';
import { CategoryCreate } from './components/categories/CategoryCreate';

const AdminDashboard = () => {
    return (
        <Admin dataProvider={dataProvider}>
            <Resource name="categories" list={CategoryList} edit={CategoryEdit} create={CategoryCreate} />
        </Admin>
    );
};

export default AdminDashboard;