<template>
    <!--展示单个商品信息简略信息-->
    <div>
        <van-grid :column-num="2" :border="false">
            <van-grid-item v-for="(item,index) in goodsList" :key="index"
                           @click="clickItem(item.id)">
                <!--使用插槽自定义样式-->
                <template #default>
                    <img :src="item.list_pic_url" style="width: 100%;height: 100%"/>
                    <div>{{item.name}}</div>
                    <div class="money">￥{{item.retail_price}}元</div>
                </template>
            </van-grid-item>
        </van-grid>
    </div>
</template>

<script>

    export default {
        name: "Product",
        props: ['goodsList'],
        data() {
            return {}
        },
        methods: {
            clickItem(goodId) {
                //若已经是详情页则直接更新页面内容
                if (this.$route.path === '/productDetail') {
                    this.$PubSub.publish('updateProductDetail', goodId);
                    return;
                }
                this.$router.replace('/productDetail?id=' + goodId)
            }
        }
    }
</script>

<style scoped>
    .money {
        font-weight: bold;
        color: red;
    }
</style>