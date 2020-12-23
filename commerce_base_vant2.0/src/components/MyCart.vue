<template>
    <!--购物车组件-->
    <div style="width: 100%">
        <Tips/>
        <van-checkbox-group :disabled="isShowStepper" v-model="result" ref="checkboxGroup">
            <van-checkbox v-for="item in cartList" :key="item.id" :name="item.product_id"
                          @click="clickItem(item)">
                <van-swipe-cell>
                    <van-card :num="item.number"
                              :price="item.retail_price.toFixed(2)"
                              :title="item.goods_name"
                              :thumb="item.list_pic_url">
                        <template #footer v-if="isShowStepper">
                            <van-stepper @change="stepperChange(item)" v-model="item.number" integer/>
                        </template>
                    </van-card>
                    <template #right>
                        <van-button square text="删除" type="danger"
                                    class="delete-button" @click="deleteButton(item)"/>
                    </template>
                </van-swipe-cell>
            </van-checkbox>
        </van-checkbox-group>
        <van-submit-bar :price="goodsTotalPrice" button-text="提交订单" @submit="onSubmit">
            <van-checkbox :disabled="isShowStepper" v-model="isAllCheck" @click="allChecked">
                全选
            </van-checkbox>
            <template #tip>
                累计<span>{{cartTotal.goodsCount}}</span>件商品,可点击
                <van-button :type="isShowStepper?'danger':'primary'" size="mini"
                            @click="isShowStepper = !isShowStepper">
                    {{isShowStepper?'完成编辑':'编辑'}}
                </van-button>
                按钮进行商品数量修改
            </template>
        </van-submit-bar>
    </div>
</template>

<script>
    import Tips from "../components/Tips";
    import {
        getCardData, goodsStatusChange, goodsNumberChange
        , deleteGoods
    } from "../request/api";

    export default {
        name: "MyCart",
        data() {
            return {
                //控制步进器显示
                isShowStepper: false,
                result: [],
                //商品是否被选中,商品名称，价格等信息
                cartList: [],
                //计算后的总量,价格等信息
                cartTotal: {}
            }
        },
        computed: {
            //控制全选框状态
            isAllCheck: {
                get() {
                    //当所有复选框被选中,数组的长度等于商品的长度
                    return (this.result.length === this.cartList.length) && (this.result.length > 0)
                }, set() {
                }
            },
            //商品总价计算
            goodsTotalPrice: {
                get() {
                    let totalPrice = 0;
                    //获取购物车中所有的商品信息,根据选中状态进行商品总价计算
                    this.cartList.forEach(item => {
                        if (item.checked === 1) {
                            totalPrice += item.retail_price * item.number;
                        }
                    })
                    return totalPrice * 100;
                }, set() {
                }
            }
        },
        methods: {
            //点击单个item事件
            clickItem(item) {
                //编辑状态不允许更改购物车状态
                if (this.isShowStepper) {
                    return
                }
                goodsStatusChange({
                    //取反 不能使用!item.checked 返回boolean,后台要求是数字
                    isChecked: item.checked === 1 ? 0 : 1,
                    productIds: item.product_id.toString()
                }).then(resp => {
                    this.renderData(resp.data.data);
                })
            },
            //全选按钮
            allChecked() {
                if (this.isShowStepper) {
                    return
                }
                const status = this.isAllCheck;
                // 已经被全部选中则更新为全部未选中
                if (status) {
                    goodsStatusChange({
                        isChecked: 0,
                        productIds: this.result.join(','),
                    }).then(resp => {
                        this.renderData(resp.data.data);
                    })
                } else {
                    //未被全部选中则更新为全部选中,需要设置下全选,否则result没有值
                    this.$refs.checkboxGroup.toggleAll(true);
                    goodsStatusChange({
                        isChecked: 1,
                        productIds: this.result.join(','),
                    }).then(resp => {
                        this.renderData(resp.data.data);
                    })
                }
            },
            //步进器值发生改变
            stepperChange(item) {
                const {goods_id, id, number, product_id} = item
                goodsNumberChange(
                    {
                        goodsId: goods_id,
                        id,
                        number,
                        productId: product_id
                    }).then(resp => {
                    this.renderData(resp.data.data)
                })
            },
            onSubmit() {
                this.$toast.success('功能暂未实现！')
            },
            //左滑删除商品
            deleteButton(item) {
                const {product_id} = item
                deleteGoods({productIds: product_id.toString()}).then(resp => {
                    this.renderData(resp.data.data)
                })
            },
            //渲染数据
            renderData(data) {
                const {cartList, cartTotal} = data
                this.cartList = cartList
                this.cartTotal = cartTotal
                //判断每个商品是否被选中,checked===1为选中,
                //添加到按钮组中进行渲染
                //每次添加之前清空下数组中数据
                this.result = []
                this.cartList.map(val => {
                    if (val.checked === 1) {
                        this.result.push(val.product_id)
                    }
                })
            }
        },
        created() {
            getCardData().then(resp => {
                this.renderData(resp.data.data)
            })
        },
        components: {Tips}
    }
</script>

<style scoped>
    .van-submit-bar {
        margin-bottom: .5rem;
        text-align: center;
        font-weight: bold;
    }

    /*display:flex为弹性布局,设置为1则为填充满*/
    /*有的时候修改框架的样式没有效果试着尝试深度修改*/
    /deep/ .van-checkbox__label {
        flex: 1;
        padding: .05rem;
    }

    .van-card {
        background: white;
    }

    .delete-button {
        height: 100%;
    }
</style>