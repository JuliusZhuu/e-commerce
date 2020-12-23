<template>
    <!--实时搜索列表数据显示-->
    <div>
        <van-list v-model="loading"
                  :finished="finished"
                  finished-text="没有更多了">
            <van-cell v-for="item in searchList" :key="item" @click="cellClick">
                {{item}}
            </van-cell>
        </van-list>
    </div>
</template>

<script>
    export default {
        name: "List",
        data() {
            return {
                list: [],
                loading: false,
                finished: true,
            }
        },
        methods: {
            cellClick(event) {
                const keyword = event.currentTarget.innerText
                this.$PubSub.publish('cellClick',{keyword})
            }
        },
        props: ['searchList']
    }
</script>

<style scoped>

</style>