import Vue from 'vue'
import VueRouter from 'vue-router'
import storageUtil from "../util/storageUtil";

Vue.use(VueRouter)
/*解决路由跳转的警告bug*/
const routerPush = VueRouter.prototype.push
const routerPlace = VueRouter.prototype.replace
VueRouter.prototype.push = function push(location) {
    return routerPush.call(this, location).catch(error => error)
}
VueRouter.prototype.replace = function replace(location) {
    return routerPlace.call(this, location).catch(error => error)
}
const routes = [
    {
        path: '/home',
        name: 'Home',
        component: () => import('../views/Home.vue'),
        children: [
            {
                path: 'popup',
                name: 'MyPopup',
                component: () => import('../views/MyPopup')
            }
        ]
    },
    {
        path: '/productDetail',
        name: 'ProductDetail',
        component: () => import('../views/ProductDetail')
    },
    {
        path: '/',
        //重定向访问请求
        redirect: '/home'
    },
    {
        path: '/topic',
        name: 'Topic',
        component: () => import('../views/Topic')
    },
    {
        path: '/category',
        name: 'Category',
        component: () => import('../views/Category')
    },
    {
        path: '/cart',
        name: 'Cart',
        component: () => import('../views/Cart')
    },
    {
        path: '/user',
        name: 'User',
        component: () => import('../views/User')
    }
]

const router = new VueRouter({
    routes
})

/**
 * 导航守卫（前置导航守卫）
 * to 将要跳转的路由
 * from 将要离开路由
 * next  函数对象,用于跳转
 */
router.beforeEach((to, from, next) => {
    //若要去购物车需要已经登录
    if (to.path === '/cart') {
        //检查是否已经登录
        const token = storageUtil.getToken();
        if (token) {
            next();
        } else {
            Vue.prototype.$toast('请先登录!')
            setTimeout(() => {
                next('/user')
            }, 1000)
        }
        return
    }
    //针对所有路由,都不进行拦截
    next()
})

export default router
