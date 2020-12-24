<template>
    <!--点击首页搜索弹出框-->
    <div class="popup">
        <van-search v-model="searcherValue" :placeholder="placeHolder" show-action
                    @search="onSearch"
                    @cancel="onCancel"
                    @input="inputChange"
                    shape="round" background="#fff"/>
        <!--传递给子组件-->
        <HistoryAndHot v-if="blockShow===1" :historyKeywordList="historyKeywordList"
                       :hotKeywordList="hotKeywordList"/>
        <MyList :searchList="searchList" v-else-if="blockShow===2"/>
        <MyProduct :goodsList="goodsList" :filterCategory="filterCategory" v-else/>
    </div>
</template>

<script>
    import HistoryAndHot from "../components/HistoryAndHot";
    import MyProduct from "../components/MyProduct";
    import MyList from "../components/MyList";
    import {getPopupData, getSearch, getTimeSearch} from "../request/api";

    export default {
        name: "MyPopup",
        data() {
            return {
                searcherValue: '',
                placeHolder: '',
                //区块显示,
                //1代表历史记录与热门区块搜索
                //2代表列表区块
                //3代表产品区块
                blockShow: 1,
                historyKeywordList: [],
                hotKeywordList: [],
                //搜索符合条件的商品信息
                goodsList: [],
                //分类信息
                filterCategory: [],
                searchList: []
            }
        },
        created() {
            getPopupData().then(res => {
                const {defaultKeyword, historyKeywordList, hotKeywordList} = res
                this.placeHolder = defaultKeyword
                //传递给子组件
                this.historyKeywordList = historyKeywordList
                this.hotKeywordList = hotKeywordList
            })
            //订阅消息
            this.$PubSub.subscribe('priceChange', (msg, data) => {
                if ('priceChange' === msg) {
                    this.onSearch({order: data})
                }
            })
            this.$PubSub.subscribe('catalogChange', (msg, data) => {
                if ('catalogChange' === msg) {
                    this.onSearch({categoryId: data})
                }
            })
            this.$PubSub.subscribe('tagChange', (msg, keyword) => {
                if ('tagChange' === msg) {
                    //设置到搜索框中
                    this.searcherValue = keyword.keyword
                    this.onSearch(keyword)
                }
            })
            this.$PubSub.subscribe('cellClick', (msg, keyword) => {
                if ('cellClick' === msg) {
                    //设置到搜索框中
                    this.searcherValue = keyword.keyword
                    this.onSearch(keyword)
                }
            })
        },
        methods: {
            /**
             * 执行搜索操作
             * @param keyword 搜索关键词
             * @param page 当前页数
             * @param size 每页显示的条数
             * @param order 排序方式,支持desc降序,asc升序
             * @param categoryId 分类id
             * @param sort  排序方式可以是id或者price
             */
            onSearch({keyword = this.searcherValue, page = 1, size = 20, order = 'desc', categoryId = 0, sort = 'id'}) {
                //查询条件
                const queryCondition = {keyword, page, size, order, categoryId, sort}
                getSearch(queryCondition).then(resp => {
                    //切换到产品区块
                    this.blockShow = 3;
                    //传递给子组件
                    const {goodsList, filterCategory} = resp
                    this.goodsList = goodsList
                    //处理filterCategory设置为text和value
                    //首先将json对象转换成JSON字符串，然后进行替换操作,最后在解析成JSON对象
                    this.filterCategory = JSON.parse(JSON.stringify(filterCategory)
                        .replace(/name/g, 'text')
                        .replace(/id/g, 'value'))
                })
            },
            /**
             * 搜索输入框内容发生改变
             * @param keyword 搜索关键词
             */
            inputChange(keyword) {
                if (keyword.trim().length > 0) {
                    this.blockShow = 2
                    getTimeSearch({keyword}).then(resp => {
                        this.searchList = resp
                    })
                } else {
                    //清空
                    this.searchList = []
                }
            },
            onCancel() {
                this.$router.push('/home')
            }
        },
        components: {HistoryAndHot, MyProduct, MyList}
    }
</script>

<style scoped>
    .popup {
        width: 100%;
        height: 100%;
        position: absolute;
        z-index: 99;
        top: 0;
        right: 0;
        background-color: rgb(247, 248, 250);
    }
</style>