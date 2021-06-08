import axios from 'axios'
import storageUtil from '../util/storageUtil'

const instance = axios.create({
    baseURL: 'http://localhost:8089',
    // baseURL: 'http://192.168.0.100:8089',
    timeout: 3000
})
//请求拦截
instance.interceptors.request.use(config => {
    let token = storageUtil.getToken();
    if (token.length > 0) {
        config.headers['e-commerce-Authorization'] = token
    }
    return config;
}, error => {
    return Promise.reject(error)
})

//响应拦截
instance.interceptors.response.use(response => {
    return response.data;
}, error => {
    return Promise.reject(error);
})

//暴露出去
export default instance
