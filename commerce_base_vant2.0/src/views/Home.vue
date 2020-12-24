<template>
    <!--底部导航首页-->
    <div class="home">
        <!--处理首页内容过长会增加到/home/popup下面-->
        <div v-if="$route.path==='/home'">
            <van-search placeholder="请输入搜索关键词"
                        shape="round" background="#fff" @click="gotoPopup"/>
            <van-swipe autoplay="3000">
                <van-swipe-item v-for="(image) in banner" :key="image.id">
                    <img :src="image.imageUrl" width="100%"/>
                </van-swipe-item>
            </van-swipe>
            <!--首页频道-->
            <MyChannel :channel="channel"/>
            <!--品牌制造商直供-->
            <MyBrand :brandList="brandList"/>
            <!--推荐内容-->
            <div class="like">
                <h4>猜你喜欢</h4>
                <Product :goodsList="goodsList"/>
            </div>

        </div>
        <transition name="van-slide-right">
            <router-view v-if="$route.path==='/home/popup'"/>
        </transition>
    </div>
</template>

<script>
    import {getHomeData, getSearch} from "../request/api";
    import MyChannel from "../components/MyChannel";
    import MyBrand from "../components/MyBrand";
    import Product from "../components/Product";

    export default {
        name: 'Home',
        data() {
            return {
                //轮播图
                banner: [],
                //首页频道
                channel: [],
                //首页品牌制作商直供
                brandList: [],
                //推荐内容
                goodsList: []
            }
        },
        created() {
            getHomeData().then(resp => {
                const {banner, channel, brandList} = resp
                this.banner = banner
                this.channel = channel
                this.brandList = brandList
            })
            /**
             * 获取推荐信息,应该从数据库中获取到用户常用关键词
             * 分别用这些关键词搜索数据,然后添加到列表中显示
             */
            getSearch({keyword: '日式'}).then(resp => {
                const {goodsList} = resp
                this.goodsList = goodsList
            })
        },
        methods: {
            gotoPopup() {
                this.$router.push('/home/popup');
            }
        },
        components: {MyChannel, MyBrand, Product}
    }
</script>
<style scoped>
    .like {
        text-align: center;
        font-weight: bold;
        padding-bottom: 1rem;
    }
</style>