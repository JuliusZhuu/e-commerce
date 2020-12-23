import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import vantui from './vantui'
import PubSub from 'pubsub-js'
Vue.prototype.$PubSub = PubSub

Vue.config.productionTip = false

new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app')
