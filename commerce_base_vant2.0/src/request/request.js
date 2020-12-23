import axios from 'axios'
import storageUtil from '../util/storageUtil'

const instance = axios.create({
    baseURL: 'http://kumanxuan1.f3322.net:8001',
    timeout: 3000
})
//请求拦截
instance.interceptors.request.use(config => {
    let token = storageUtil.getToken();
    if (token.length > 0) {
        config.headers['X-Nideshop-Token'] = token
    }
    return config;
}, error => {
    return Promise.reject(error)
})

//响应拦截
instance.interceptors.response.use(response => {
    return response;
}, error => {
    return Promise.reject(error);
})

//暴露出去
export default instance