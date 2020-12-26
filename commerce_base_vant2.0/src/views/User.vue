<template>
    <!--底部导航用户-->
    <div class="user">
        <van-row>
            <van-col span="8">
                <img :src="avatar"/>
            </van-col>
            <van-col span="14" @click="clickUser">{{nickName}}</van-col>
            <van-col span="2">
                <van-icon name="arrow"/>
            </van-col>
        </van-row>
        <!--登录界面-->
        <div class="login_modal" v-if="showForm">
            <section @click="closeModal"></section>
            <van-form validate-first @submit="submit">
                <van-field required colon label="用户名" v-model="username"
                           placeholder="请输入用户名"
                           :rules="[{ validator, message: '请输入正确内容' }]"/>
                <van-field required colon label="密码"
                           v-model="password" placeholder="请输入用户密码" type="password"
                           :rules="[{ validator, message: '请输入正确内容' }]"/>
                <div style="margin: 16px;">
                    <van-button round block type="info">提交</van-button>
                </div>
            </van-form>
        </div>
        <van-grid :column-num="3" square>
            <van-grid-item @click="clickItem" v-for="(item,index) in gridData" :key="index" :icon="item.icon"
                           :text="item.text"/>
        </van-grid>
    </div>
</template>

<script>
    import {goLogin} from "../request/api";
    import storageUtil from '../util/storageUtil'

    export default {
        name: "User",
        data() {
            return {
                showForm: false,
                avatar: require('../assets/images/avatar.png'),
                nickName: '点击登录',
                username: '',
                password: '',
                gridData: [
                    {value: 0, text: '我的订单', icon: 'orders-o'},
                    {value: 1, text: '优惠券', icon: 'cash-on-deliver'},
                    {value: 2, text: '礼品卡', icon: 'gift-o'},
                    {value: 3, text: '我的收藏', icon: 'goods-collect-o'},
                    {value: 4, text: '我的足迹', icon: 'location-o'},
                    {value: 5, text: '会员福利', icon: 'manager-o'},
                    {value: 6, text: '地址管理', icon: 'setting-o'},
                    {value: 7, text: '账号安全', icon: 'warn-o'},
                    {value: 8, text: '联系客服', icon: 'service-o'},
                    {value: 9, text: '帮助中心', icon: 'question-o'},
                    {value: 10, text: '意见反馈', icon: 'service-o'}
                ]
            }
        },
        mounted() {
            if (storageUtil.getToken().length > 0) {
                const userInfo = storageUtil.getUser();
                this.avatar = userInfo.avatar
                this.nickName = userInfo.nickname
            } else {
                this.showForm = true
            }
        },
        methods: {
            //登录
            submit() {
                const {username, password} = this
                goLogin({username, password}).then(resp => {
                    const {loginResult, user} = resp
                    if (loginResult === '登录成功') {
                        //本地化存储数据
                        storageUtil.saveToken(user.token)
                        storageUtil.saveUser(user)
                        this.$toast.success('登录成功!')
                        //更新头像与关闭窗口
                        this.avatar = user.avatar
                        this.nickName = user.nickName
                        setTimeout(() => {
                            this.showForm = false
                        }, 1000)
                    } else {
                        this.$toast.fail('登录失败!')
                    }
                }).catch(() => {
                    this.$toast.fail('登录失败!')
                })
            },
            //点击当前用户名
            clickUser() {
                //判断是否已经登录
                if (!storageUtil.getToken().length > 0) {
                    this.showForm = true
                }
            },
            //关闭模态层和登录窗口
            closeModal() {
                this.showForm = false
            },
            validator(val) {
                return val.trim().length > 0;
            },
            clickItem() {
                this.$toast.fail('功能暂未开放!');
            }
        }
    }
</script>

<style lang="less" scoped>
    .user {
        padding-bottom: .5rem;
    }

    .van-row {
        padding: .2rem 4%;
        font-weight: bold;
        color: white;
        background-color: black;
    }

    .van-col {
        line-height: .8rem;
    }

    img {
        width: .8rem;
        /*使图片变圆*/
        border-radius: 50%;
        display: block;
    }

    .login_modal {
        width: 100%;
        /*元素是否有内容都会撑开*/
        height: 100vh;
        position: absolute;
        /* 属性设置元素的堆叠顺序。拥有更高堆叠顺序的元素总是会处于堆叠顺序较低的元素的前面。*/
        /* 结合position使用*/
        z-index: 99;

        /*设置模态层，专门用于取消*/

        section {
            background: gray;
            height: 100vh;
        }

        .van-form {
            /*绝对定位*/
            position: absolute;
            top: 0;
            left: 0;
            background: #fff;
            margin: 40% 15%;
        }
    }
</style>