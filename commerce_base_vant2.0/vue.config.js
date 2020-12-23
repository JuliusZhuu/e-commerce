module.exports = {
    //关闭eslint检查,false为关闭
    lintOnSave: false,
    //配置打包时候的路径,/直接使用会出现找不到资源
    publicPath: process.env.VUE_APP_NODE_ENV === 'production' ? './' : '/',
    devServer:{
        //浏览器自动打开和端口配置
        open:true,
        port:8088
    }
}