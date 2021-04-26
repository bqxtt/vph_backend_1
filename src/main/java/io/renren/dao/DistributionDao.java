package io.renren.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.renren.entity.DistributionEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 
 * 
 * @author ghw
 * @email 1044386387@qq.com
 * @date 2020-06-12 20:10:29
 */
@Mapper
public interface DistributionDao extends BaseMapper<DistributionEntity> {
    @Select("SELECT * from distribution where name like CONCAT('%',#{key},'%')")
    List<DistributionEntity> search1(IPage page,@Param("key") String key);
    @Select("SELECT * from distribution where accept_company like CONCAT('%',#{key},'%')")
    List<DistributionEntity> search2(IPage page,@Param("key") String key);
}
