import React, { useState } from 'react';
import api from './api';
import 'bootstrap/dist/css/bootstrap.min.css';

function Login() {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const handleLogin = async (e) => {
        e.preventDefault();
        const response = await fetch('http://localhost:8080/api/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ email, password }),
        });

        if (response.ok) {
            alert('Login successful');
            // Redirect to main page after login if needed
        } else {
            alert('Login failed');
        }
    };

    return (
        <div style={{ maxWidth: '400px', margin: 'auto', textAlign: 'center' }}>
            <h2>Login</h2>
            <form onSubmit={handleLogin}>
                <div style={{ marginBottom: '15px' }}>
                    <label>Email:</label>
                    <input
                        type="email"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                        required
                        style={{ width: '100%', padding: '10px', fontSize: '16px' }}
                    />
                </div>
                <div style={{ marginBottom: '15px' }}>
                    <label>Password:</label>
                    <input
                        type="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        required
                        style={{ width: '100%', padding: '10px', fontSize: '16px' }}
                    />
                </div>
                <button type="submit" style={{ padding: '10px 20px', fontSize: '16px' }}>
                    Login
                </button>
            </form>
        </div>
    );
}

export default Login;