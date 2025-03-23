import { jwtDecode } from "jwt-decode";

export function getUser() {
    const token = localStorage.getItem('token');
    if (!token) {
        return null;
    }

    return jwtDecode(token);
}

export function isLoggedIn() {
    const token = localStorage.getItem('token');
    if (!token) {
        return false;
    }

    const decodedToken = jwtDecode(token);
    const isExpired = decodedToken.exp ? decodedToken.exp * 1000 < Date.now() : true;
    if (isExpired) {
        localStorage.removeItem('token');
    }
    console.log('isExpired', isExpired);
    return !isExpired;
}
