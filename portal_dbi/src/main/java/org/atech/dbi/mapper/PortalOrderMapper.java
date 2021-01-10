package org.atech.dbi.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.atech.facade.domain.Order;
import org.atech.facade.domain.OrderDetail;

import java.util.List;

/**
 * 前台订单自定义Dao
 * Created by macro on 2018/9/4.
 */
@CacheNamespace(blocking = true)
public interface PortalOrderMapper extends BaseMapper<Order> {
    /**
     * 3.x 的 page 可以进行取值,多个入参记得加上注解
     * 自定义 page 类必须放在入参第一位
     * 返回值可以用 IPage<T> 接收 也可以使用入参的 MyPage<T> 接收
     * <li> 3.1.0 之前的版本使用注解会报错,写在 xml 里就没事 </li>
     * <li> 3.1.0 开始支持注解,但是返回值只支持 IPage ,不支持 IPage 的子类</li>
     *
     * @param myPage 自定义 page
     * @return 分页数据
     * user where (age = #{pg.selectInt} and name = #{pg.selectStr}) or (age = #{ps.yihao} and name = #{ps.erhao})
     */
    @Select("select * from t_order")
    MyPage<Order> mySelectPage(@Param("pg") MyPage<Order> myPage);


//    @ResultMap("userChildrenMap")
//    @Select("<script>select u.id,u.name,u.email,u.age,c.id as \"c_id\",c.name as \"c_name\",c.user_id as \"c_user_id\" " +
//            "from user u " +
//            "left join children c on c.user_id = u.id " +
//            "<where>" +
//            "<if test=\"selectInt != null\"> " +
//            "and u.age = #{selectInt} " +
//            "</if> " +
//            "<if test=\"selectStr != null and selectStr != ''\"> " +
//            "and c.name = #{selectStr} " +
//            "</if> " +
//            "</where>" +
//            "</script>")
//    MyPage<UserChildren> userChildrenPage(MyPage<UserChildren> myPage);
}
