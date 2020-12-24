<template>
    <!--历史与热门-->
    <div>
        <van-row>
            <van-col class="title" span="22">历史记录</van-col>
            <van-col span="2">
                <van-icon name="delete" @click="clearTag"/>
            </van-col>
        </van-row>
        <van-row gutter="10">
            <van-col v-for="(item,index) in historyKeywordList" :key="index">
                <van-tag @click="historyKeywordTag" plain type="default">{{item}}</van-tag>
            </van-col>
        </van-row>
        <van-row>
            <van-col class="title" span="24">热门搜索</van-col>
        </van-row>
        <van-row gutter="10">
            <van-col v-for="(item,index) in hotKeywordList" :key="index">
                <van-tag @click="hotKeywordTag" plain :type="item.isHot===1?'danger':'default'">
                    {{item.keyword}}
                </van-tag>
            </van-col>
        </van-row>
    </div>
</template>

<script>
    export default {
        name: "HistoryAndHot",
        methods: {
            /**
             * 历史关键词标签
             * @param event javascript原生对象
             */
            historyKeywordTag(event) {
                const keyword = event.currentTarget.innerText
                this.$PubSub.publish('tagChange', {keyword})
            },
            /**
             * 热门关键词标签
             * @param event javascript原生对象,可通过currentTarget.innerText获取内容
             */
            hotKeywordTag(event) {
                const keyword = event.currentTarget.innerText
                //执行搜索操作
                this.$PubSub.publish('tagChange', {keyword})
            },
            //清空标签
            clearTag() {
                //应该发送请求到服务器端进行清除,本地清除没有意义
            }
        },
        props: ['historyKeywordList', 'hotKeywordList']
    }
</script>

<style scoped>
    .van-row {
        padding: .05rem;
    }

    .van-col {
        padding: .05rem;
    }

    .title {
        font-weight: bold;
    }
</style>