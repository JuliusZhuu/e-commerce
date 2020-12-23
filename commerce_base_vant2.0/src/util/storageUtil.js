/*本地化存储数据工具类*/
/*电商token*/
const COMMERCE_TOKEN = 'commerce_token';
/*用户登录信息*/
const USER_INFO = 'user_info';
export default {
    saveToken(token) {
        window.localStorage.setItem(COMMERCE_TOKEN, JSON.stringify(token));
    },
    getToken() {
        return JSON.parse(window.localStorage.getItem(COMMERCE_TOKEN) || '[]');
    },
    saveUser(user) {
        window.localStorage.setItem(USER_INFO, JSON.stringify(user));
    },
    getUser() {
        return JSON.parse(window.localStorage.getItem(USER_INFO) || '[]');
    }
}