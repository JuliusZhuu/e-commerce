<template>
    <!--商品详情页底部商品导航-->
    <div>
        <van-goods-action>
            <van-goods-action-icon :icon="isCollect?'star':'star-o'" :color="isCollect?'red':'#666'"
                                   :text="isCollect?'已收藏':'未收藏'" @click="collect(!isCollect)"/>
            <van-goods-action-icon :badge="badge" icon="shopping-cart-o" text="购物车" @click="goCart"/>
            <van-goods-action-button type="warning" text="加入购物车"
                                     @click="$PubSub.publish('showSku',true)"/>
            <van-goods-action-button type="danger" text="立即购买"
                                     @click="$PubSub.publish('showSku',true)"/>
        </van-goods-action>
    </div>
</template>

<script>
    import {getCartCount} from "../request/api";

    export default {
        name: "MyGoodsActions",
        data() {
            return {
                //控制收藏显示
                isCollect: false,
                //购物车数量
                badge: 0
            }
        },
        mounted() {
            this.initData()
            //订阅消息
            this.$PubSub.subscribe('updateCartCount', (msg, data) => {
                if ('updateCartCount' === msg) {
                    this.initData(data)
                }
            })
        },
        methods: {
            //去购物车页面
            goCart() {
                this.$router.push('/cart')
            },
            //初始化购物车数量
            initData() {
                getCartCount().then(resp => {
                    this.badge = resp.goodsCount;
                })
            },
            //收藏
            collect(isCollect) {
                //发送到后台请求,收藏成功之后再更新状态
                setTimeout(() => {
                    this.$toast.success('成功')
                    this.isCollect = isCollect
                }, 1000)
            }
        }
    }
</script>

<style scoped>

</style>