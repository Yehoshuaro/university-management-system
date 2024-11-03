import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Login from './Login';
import Register from './Register';
import HomePage from './HomePage';
import PrivateRoute from './PrivateRoute';

function App() {
    return (
        <Router>
            <Routes>
                <Route path="/login" element={<Login />} />
                <Route path="/register" element={<Register />} />
                <Route path="/" element={<PrivateRoute><HomePage /></PrivateRoute>} />
            </Routes>
        </Router>
    );
}

export default App;