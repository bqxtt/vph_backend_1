package io.renren.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.renren.entity.PorderEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 
 * 
 * @author ghw
 * @email 1044386387@qq.com
 * @date 2020-12-18 23:09:27
 */
@Mapper
public interface PorderDao extends BaseMapper<PorderEntity> {
    @Select("SELECT * from porder where name = #{username}")
    List<PorderEntity> search1(IPage page, @Param("username") String username);
    @Select("SELECT first_price from flight where id = #{flight_id}")
    Double getPriceByFlightId1( @Param("flight_id") Integer flightId);
    @Select("SELECT business_price from flight where id = #{flight_id}")
    Double getPriceByFlightId2( @Param("flight_id") Integer flightId);
    @Select("SELECT economy_price from flight where id = #{flight_id}")
    Double getPriceByFlightId3( @Param("flight_id") Integer flightId);
    @Select("SELECT count(*) from flight where id = #{flight_id}")
    Integer hasThisFlightId( @Param("flight_id") Integer flightId);
    @Select("SELECT * from porder where id = #{order_id}")
    PorderEntity selcetPorderById( @Param("order_id") Integer orderId);
}
