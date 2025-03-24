import axios from 'axios'
const API_URL = import.meta.env.VITE_BACKEND_URL

export class Api {
    api: any;
    constructor(secured = false) {
        this.api = axios.create({
            baseURL: API_URL,
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            }
        })

        if (secured) {
            this.api.interceptors.request.use(
                config => {
                    const token = localStorage.getItem('token')
                    if (token) {
                        config.headers.Authorization = `Bearer ${token}`
                    }
                    return config
                },
                error => {
                    return Promise.reject(error)
                }
            )
        }
    }

    async get(url: string, data = {}, options = {}) {
        return this.api.get(url, data, options)
    }

    async post(url: string, data = {}, options = {}) {
        return this.api.post(url, data, options)
    }

    async put(url: string, data = {}, options = {}) {
        return this.api.put(url, data)
    }

    async delete(url: string) {
        return this.api.delete(url)
    }

}