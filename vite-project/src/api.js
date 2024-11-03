// src/api.js
import axios from 'axios';

const api = axios.create({
    baseURL: 'http://localhost:5173/', // Замените на URL вашего backend
});

export default api;
api.interceptors.request.use((config) => {
    const token = localStorage.getItem('token');
    if (token) {
        config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
});