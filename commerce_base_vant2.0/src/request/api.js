import request from './request'

/*请求首页数据*/
export const getHomeData = () => request.get('/index/index')
/*获取popup的数据*/
export const getPopupData = () => request.get('/search/index')
/*搜索框商品搜索*/
export const getSearch = params => request.get('/goods/list', {params})
/*实时搜索功能*/
export const getTimeSearch = params => request.get('/search/helper', {params})
/*登录请求*/
export const goLogin = params => request.post('/auth/loginByWeb', params)
/*查看商品的详细信息*/
export const getProductDetail = params => request.get('/goods/detail', {params})
/*相关产品*/
export const getAbout = params => request.get('/goods/related', {params})
/*获取用户购物车中商品数量,需要在请求头携带token*/
export const getCartCount = params => request.get('/cart/goodsCount', {params})
/*加入到购物车*/
export const addProductToCart = params => request.post('/cart/add', params)
/*获取购物车数量,含编辑*/
export const getCardData = params => request.get('/cart/index', {params})
/*点击切换商品选中状态,包括多选*/
export const goodsStatusChange = params => request.put('/cart/checked', params)
/*购物车商品数量发生改变*/
export const goodsNumberChange = params => request.put('/cart/update', params)
/*删除购物车商品信息*/
export const deleteGoods = params => request.post('/cart/delete', params)