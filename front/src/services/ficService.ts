import { Api } from './api'

export default {
    getProfilePictureByUserId(userId: string) {
        // Get blob from server
        return new Api(true).get(`/fic/profile-picture/${userId}`, {
            responseType: 'blob'
        }).then(response => {
            return response.data
        })
    },
    getProfilePictureWithDefaultByUserId(userId: string) {
        // Get blob from server
        return new Api(true).get(`/fic/profile-picture-with-default/${userId}`, {
            responseType: 'blob'
        }).then(response => {
            return response.data
        })
    },
    uploadProfilePicture(file: Blob) {
      let formData = new FormData();
      formData.append('file', file);
  
      return new Api(true).post('/fic/upload-profile-picture', formData, {
        headers: {
            'Content-Type': 'multipart/form-data'
        }
      }).then(response => {
          return response.data
      })
    },
    deleteProfilePicture() {
        return new Api(true).delete('/fic/profile-picture').then(response => {
            return response.data
        })
    }
}