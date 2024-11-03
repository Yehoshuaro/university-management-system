import React from 'react';
import { Link } from 'react-router-dom';

function Home() {
    return (
        <div style={{ textAlign: 'center' }}>
            <h1>Welcome to the University Management System</h1>
            <p>Manage your university's information effectively and securely.</p>
            <Link to="/login" style={{ fontSize: '20px', color: '#007BFF' }}>
                Go to Login
            </Link>
        </div>
    );
}

export default Home;
