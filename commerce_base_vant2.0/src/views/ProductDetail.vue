<template>
    <!--商品详情页-->
    <div>
        <div class="top_bar" id="top">
            <van-row gutter="350">
                <van-col span="12">
                    <div>
                        <van-icon size="30" name="arrow-left" @click="back"/>
                    </div>
                </van-col>
                <van-col span="12">
                    <div>
                        <van-icon size="30" name="share-o" @click="showShare=true"/>
                    </div>
                </van-col>
            </van-row>
        </div>
        <!--分享-->
        <van-share-sheet v-model="showShare" title="立即分享给好友"
                         :options="options"/>
        <!--轮播图-->
        <van-swipe autoplay="3000">
            <van-swipe-item v-for="(image) in gallery" :key="image.id">
                <van-image width="100%" height="3rem" :src="image.imgUrl"/>
            </van-swipe-item>
        </van-swipe>
        <Tips/>
        <!--简单描述信息-->
        <div class="info">
            <h4>{{info.name}}</h4>
            <p>{{info.goodsBrief}}</p>
            <p class="price">￥{{info.retailPrice}}元</p>
        </div>
        <!--商品参数-->
        <ul class="attribute">
            <h4>商品参数</h4>
            <li v-for="(item,index) in attribute" :key="index" class="van-ellipsis">
                <span>{{item.name}}</span><span>{{item.value}}</span>
            </li>
        </ul>
        <!--细节图,后台设计有问题,后续更改只需要传递图片路径过来即可,不需要传递整个标签-->
        <ul>
            <li v-for="(desc,index) in  info_desc" :key="index">
                <van-image width="100%" height="100%" :src="desc"/>
            </li>
        </ul>
        <!--常见问题-->
        <div class="issue">
            <van-divider>常见问题</van-divider>
            <ul>
                <li v-for="(item,index) in issue" :key="index">
                    <p class="question">●{{item.question}}</p>
                    <p class="answer">{{item.answer}}</p>
                </li>
            </ul>
        </div>
        <!--相关产品列表-->
        <div class="about">
            <van-divider>大家都在看</van-divider>
            <Product :goodsList="goodsList"/>
        </div>
        <van-sku v-model="cartShow" :sku="sku"
                 :goods="goods"
                 @add-cart="onAddCartClicked"
                 @buy-clicked="onBuyClicked">
            <!--自定义内容区域-->
            <!--            <template #sku-group>-->
            <!--                <div class="sku_desc">-->
            <!--                    <h4>颜色</h4>-->
            <!--                    <van-radio-group>-->
            <!--                        <van-radio name="1" shape="square">绿色</van-radio>-->
            <!--                        <van-radio name="2" shape="square">蓝色</van-radio>-->
            <!--                        <van-radio name="2" shape="square">黑色</van-radio>-->
            <!--                    </van-radio-group>-->
            <!--                </div>-->
            <!--                <div class="sku_desc">-->
            <!--                    <h4>尺码</h4>-->
            <!--                    <van-radio-group direction="horizontal" style="padding-left: 100px">-->
            <!--                        <van-radio name="1" shape="square">sm</van-radio>-->
            <!--                        <van-radio name="2" shape="square">xl</van-radio>-->
            <!--                        <van-radio name="2" shape="square">xxl</van-radio>-->
            <!--                    </van-radio-group>-->
            <!--                </div>-->
            <!--                <div class="sku_desc">-->
            <!--                    <h4>布料</h4>-->
            <!--                    <van-radio-group>-->
            <!--                        <van-radio name="1" shape="square">加棉</van-radio>-->
            <!--                        <van-radio name="2" shape="square">加绒</van-radio>-->
            <!--                    </van-radio-group>-->
            <!--                </div>-->
            <!--            </template>-->
        </van-sku>
        <MyGoodsActions/>
    </div>
</template>

<script>
    import {getProductDetail, getAbout, addProductToCart} from "../request/api";
    import Tips from "../components/Tips";
    import Product from "../components/Product";
    import MyGoodsActions from "../components/MyGoodsActions";
    import storageUtil from "../util/storageUtil";

    export default {
        name: "ProductDetail",
        data() {
            return {
                //显示sku
                cartShow: false,
                sku: {
                    tree: [],
                    hide_stock: false,//是否隐藏剩余库存
                    price: '',// 默认价格（单位元）
                    stock_num: 0,  //商品总库存
                },
                goods: {picture: 'https://img.yzcdn.cn/1.jpg'},
                messageConfig: {},
                //是否显示分享
                showShare: false,
                options: [
                    [
                        {name: '微信', icon: 'wechat'},
                        {name: '微博', icon: 'weibo'},
                        {name: 'QQ', icon: 'qq'},
                    ],
                    [
                        {name: '复制链接', icon: 'link'},
                        {name: '分享海报', icon: 'poster'},
                        {name: '二维码', icon: 'qrcode'},
                        {name: '小程序码', icon: 'weapp-qrcode'},
                    ]],
                //轮播图
                gallery: [],
                //商品信息
                info: {},
                //详细的图片描述
                info_desc: [
                    'https://img.alicdn.com/imgextra/i4/2207974795337/O1CN01K0AK9Z1pIOPsB4O6k_!!2207974795337-0-scmitem176000.jpg',
                    'https://img.alicdn.com/imgextra/i1/2207974795337/O1CN011DS6rg1pIOPznMVNK_!!2207974795337-0-scmitem176000.jpg',
                    'https://img.alicdn.com/imgextra/i2/2207974795337/O1CN01jq9U2e1pIOPmUhF2P_!!2207974795337-0-scmitem176000.jpg'
                ],
                //商品参数
                attribute: [],
                //常见问题
                issue: [],
                //相关产品
                goodsList: []
            }
        },
        methods: {
            /**
             * 加入购物车
             * @param skuData  sku数据
             */
            onAddCartClicked(skuData) {
                //用户未登录则跳转到登录页面
                if (!storageUtil.getToken().length > 0) {
                    this.$toast.success('请先登录')
                    setTimeout(() => {
                        this.$router.replace('/user')
                    }, 1000)
                    return
                }

                let goodsNumber = skuData.selectedNum
                let goodsId = this.info.goodsId;
                addProductToCart({goodsId, goodsNumber}).then(() => {
                    this.$toast.success('添加成功')
                    //通知子组件更新购物车数量
                    this.$PubSub.publish('updateCartCount')
                })
            },
            onBuyClicked() {
                this.$toast.success('功能暂未实现!')
            },
            back() {
                this.$router.push('/home/popup')
            },
            //初始化数据
            initData(id) {
                getProductDetail({id}).then(resp => {
                    //分别是轮播图，产品信息，产品参数，常见问题
                    const {gallery, info, attribute, issue} = resp
                    this.gallery = gallery;
                    this.info = info
                    this.attribute = attribute
                    this.issue = issue
                    //渲染sku
                    this.goods.picture = info.listPicUrl
                    this.sku.price = info.retailPrice.toFixed(2)
                    this.sku.stock_num = info.goodsNumber
                    //回到顶部
                    window.scrollTo(0, 0);
                    //获取相关产品
                    const name = this.info.name
                    getAbout({name}).then(resp => {
                        this.goodsList = resp.goodsList
                    })
                })
            }
        },
        created() {
            //订阅消息
            this.$PubSub.subscribe('updateProductDetail', (msg, id) => {
                if ('updateProductDetail' === msg) {
                    this.initData(id)
                }
            })
            this.$PubSub.subscribe('showSku', (msg, data) => {
                if ('showSku' === msg) {
                    this.cartShow = data
                }
            })
            const id = this.$route.query.id
            this.initData(id)
        },
        components: {Tips, Product, MyGoodsActions}
    }
</script>

<style lang="less" scoped>
    .top_bar {
        position: absolute;
        z-index: 99;
        top: 0;
        left: 0;
    }

    .info {
        background: white;
        text-align: center;

        .price {
            font-weight: bold;
            color: red;
        }
    }

    .attribute {
        margin: .1rem;

        li {
            padding: .05rem;
            margin-top: .05rem;
            background: #DCDCDC;

            span {
                margin-left: .1rem;
            }
        }
    }

    .issue {

        li {
            margin: .05rem;
            line-height: .2rem;
        }

        .question {
            font-weight: bold;
        }

        .answer {
            text-indent: .2rem;
        }
    }

    .van-divider {
        font-weight: bold;
        color: black;
        border-color: #DCDCDC;
        padding: 0 1rem;
    }

    /*设置前后的线条粗细*/
    .van-divider::after, .van-divider::before {
        border-width: .02rem;
    }

    .sku_desc {
        h4 {
            margin-left: .3rem;
        }

        .van-tag {
            color: black;
            margin-left: .5rem;
            padding: .05rem;
        }
    }

    .about {
        padding-bottom: .8rem;
    }
</style>