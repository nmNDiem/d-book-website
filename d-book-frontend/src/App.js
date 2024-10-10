import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import UserRoutes from './routes/UserRoutes';
import AdminRoutes from './routes/AdminRoutes';
import AdminDashboard from './admin/AdminDashboard';

function App() {
  return (
    <AdminDashboard />
    // <BrowserRouter>
    //     <Routes>
    //       <Route path='/*' element={<UserRoutes />} />
    //       <Route path='/admin/*' element={<AdminRoutes />} />
    //       <Route path='/admin/login' element={<AdminRoutes />} />
    //     </Routes>
    // </BrowserRouter>
  );
}

export default App;
