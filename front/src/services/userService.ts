import { Api } from './api'

export default {
  update(userDto: object) {
    return new Api(true).put('/user/', userDto).then(response => {
        return response.data
    })
  },
}