<template>
    <!--搜索下拉向下弹出的菜单列表,以及商品简略信息-->
    <div>
        <van-dropdown-menu >
            <van-dropdown-item title="综合" v-model="value1" disabled/>
            <van-dropdown-item title="价格" v-model="value2" :options="option2" @change="priceChange"/>
            <van-dropdown-item title="分类" v-model="value3" :options="filterCategory" @change="catalogChange"/>
        </van-dropdown-menu>
        <van-empty v-if="isEmpty" image="search" description="搜索产品不存在"/>
        <Product :goodsList="goodsList" v-else/>
    </div>
</template>

<script>
    import Product from "./Product";

    export default {
        name: "MyProduct",
        data() {
            return {
                //显示搜索到的产品
                isEmpty: false,
                value1: 0,
                value2: 0,
                value3: 0,
                option2: [
                    {text: '由高到低', value: 'desc'},
                    {text: '由低到高', value: 'asc'}
                ]
            }
        },
        methods: {
            priceChange(val) {
                //发布消息
                this.$PubSub.publish('priceChange', val);
            },
            catalogChange(val) {
                this.$PubSub.publish('catalogChange', val);
            }
        },
        props: ['goodsList', 'filterCategory'],
        components: {Product},
        mounted() {
            //遍历数组,设置选中分类
            this.filterCategory.forEach(item => {
                if (item.checked) {
                    this.value3 = item.value
                }
            })
        }
    }
</script>

<style scoped>




</style>