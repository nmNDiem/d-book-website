import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Sidebar from '../admin/components/commons/Sidebar';

const AdminRoutes = () => {
    return (
        <BrowserRouter>
            <Routes>
                <Route path='/admin' element={<Sidebar />} />
            </Routes>
        </BrowserRouter>
    );
};

export default AdminRoutes;