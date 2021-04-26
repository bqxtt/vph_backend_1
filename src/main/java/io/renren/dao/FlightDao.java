package io.renren.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.entity.FlightEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * 
 * 
 * @author ghw
 * @email 1044386387@qq.com
 * @date 2020-12-18 23:09:27
 */
@Mapper
public interface FlightDao extends BaseMapper<FlightEntity> {
    @Update("update flight set  first_seats=first_seats-#{seatGap} where id = #{flightId}")
    void subseat1(@Param("flightId") Integer flightId, @Param("seatGap") Integer seatGap);
    @Update("update flight set  business_seats=business_seats-#{seatGap} where id = #{flightId}")
    void subseat2(@Param("flightId") Integer flightId, @Param("seatGap") Integer seatGap);
    @Update("update flight set  economy_seats=economy_seats-#{seatGap} where id = #{flightId}")
    void subseat3(@Param("flightId") Integer flightId, @Param("seatGap") Integer seatGap);
    @Update("update flight set  first_seats=first_seats+#{seatGap} where id = #{flightId}")
    void addseat1(@Param("flightId") Integer flightId, @Param("seatGap") Integer seatGap);
    @Update("update flight set  business_seats=business_seats+#{seatGap} where id = #{flightId}")
    void addseat2(@Param("flightId") Integer flightId, @Param("seatGap") Integer seatGap);
    @Update("update flight set  economy_seats=economy_seats+#{seatGap} where id = #{flightId}")
    void addseat3(@Param("flightId") Integer flightId, @Param("seatGap") Integer seatGap);
}
