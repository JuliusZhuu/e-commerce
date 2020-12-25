package com.juliuszhu.ecommerce.domain.mapper;

import com.juliuszhu.ecommerce.domain.entity.CartList;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;
import java.util.List;

/**
 * date: 2020/12/25
 * time: 16:06
 *
 * @author:julius.zhu
 * @describe: 购物车mapper
 */
public interface CartMapper {
    /**
     * 根据用户名获取用户购物车数量
     *
     * @param username 用户名
     * @return
     */
    @Select("select count(*) from cart_list  where username=#{username}  and  isDelete=0")
    Integer getCartGoodsCount(String username);

    /**
     * 根据用户名获取用户购物车数据
     *
     * @param username 用户名
     * @return
     */
    @Select("select * from cart_list  where username=#{username}  and isDelete=0")
    List<CartList> getCartList(String username);

    /**
     * 根据用户名获取购物车商品总数量
     *
     * @param username 用户名
     * @return
     */
    @Select("select sum(goodsNumber) from cart_list  where username=#{username} and  isDelete=0")
    Integer goodsCount(String username);

    /**
     * 根据用户名获取购物车商品总价格
     *
     * @param username 用户名
     * @return
     */
    @Select("select sum(retailPrice*goodsNumber) from cart_list  where username=#{username} and isDelete=0")
    BigDecimal getGoodsAmount(String username);

    /**
     * 根据用户名和商品id查询购物车中是否已经存在,存在则直接更新
     *
     * @param cartList
     * @return
     */
    @Select("select  count(*)  from  cart_list  where username=#{username} and goodsId=#{goodsId}")
    Integer isExistsCartGoods(CartList cartList);

    /**
     * 将商品信息添加进购物车
     *
     * @param cartList 商品信息对象
     */
    @Insert("insert into  cart_list(username,goodsId,goodsName,retailPrice," +
            "marketPrice,goodsNumber,listPicUrl,goodsSn)" +
            "values(#{username},#{goodsId},#{goodsName},#{retailPrice},#{marketPrice}," +
            "#{goodsNumber},#{listPicUrl},#{goodsSn})")
    void addCart(CartList cartList);

    @Update("update  cart_list  set goodsNumber=#{goodsNumber},isDelete=0 " +
            "where username=#{username} and goodsId=#{goodsId}")
    void updateCartGoods(CartList cartList);

    /**
     * 根据用户名和商品id获取购物车商品信息
     *
     * @param cartList 购物车商品信息
     * @return
     */
    @Select("select *  from cart_list  where  username=#{username} and  goodsId=#{goodsId}")
    CartList getCartListByGoodsId(CartList cartList);

    @Update("update cart_list set isChecked=#{isChecked} where" +
            " username=#{username}  and  goodsId=#{goodsId} ")
    void cartUpdate(CartList cartList);

    /**
     * 批量更新购物车选中状态
     *
     * @param isChecked 选中状态
     * @param username  用户名
     * @param goodsIds  商品id数组
     */
    void cartUpdateBatch(@Param("isChecked") String isChecked,
                         @Param("username") String username,
                         @Param("goodsIds") String[] goodsIds);
}
