import { Api } from './api'

export default {
  login(email: string, password: string) {
    return new Api().post('/auth/login', { "email": email, "password": password }).then(response => {
        return response.data
    })
  },
  register(user: string) {
    return new Api().post('/auth/register', user).then(response => {
        return response.data
    })
  },
  sendResetPasswordEmail(email: string) {
    return new Api().post('/auth/send-reset-password', { "email": email }).then(response => {
        return response.data
    })
  },
  resetPassword(dto: string) {
    return new Api().post('/auth/reset-password', dto).then(response => {
        return response.data
    })
  }
}