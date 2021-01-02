<template>
    <!--所有页面的底部5大导航tab-->
    <van-tabbar v-model="active" @change="onChange">
        <van-tabbar-item icon="home-o">首页</van-tabbar-item>
        <van-tabbar-item icon="label-o">专题</van-tabbar-item>
        <van-tabbar-item icon="apps-o">分类</van-tabbar-item>
        <van-tabbar-item icon="shopping-cart-o">购物车</van-tabbar-item>
        <van-tabbar-item icon="user-o">我的</van-tabbar-item>
    </van-tabbar>
</template>

<script>
    import storageUtil from "../util/storageUtil";

    export default {
        name: "MyTabBar",
        computed: {
            active: {
                get() {
                    //获取当前路由的路径,主要用于选中哪一个tabbar
                    const path = this.$route.path
                    switch (path) {
                        case '/home':
                            return 0
                        case '/topic':
                            return 1
                        case '/category':
                            return 2
                        case '/cart':
                            return 3
                        case '/user':
                            return 4
                        default:
                            return 0
                    }
                }, set() {
                }
            }
        },
        methods: {
            //tabbar改变切换页面
            onChange(index) {
                switch (index) {
                    case 0:
                        this.$router.replace('/home')
                        break;
                    case 1:
                        this.$router.replace('/topic')
                        break;
                    case 2:
                        this.$router.replace('/category')
                        break;
                    case 3:
                        let token = storageUtil.getToken();
                        if (token.length > 0) {
                            this.$router.replace('/cart')
                        } else {
                            this.$toast.fail('请先登录!')
                        }
                        break;
                    case 4:
                        this.$router.replace('/user')
                        break;
                }
            }
        }
    }
</script>

<style scoped>

</style>