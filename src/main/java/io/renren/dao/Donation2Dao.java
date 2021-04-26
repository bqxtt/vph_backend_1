package io.renren.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.renren.entity.Donation2Entity;
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
public interface Donation2Dao extends BaseMapper<Donation2Entity> {
    @Select("SELECT * from donation2 where name like CONCAT('%',#{key},'%')")
    List<Donation2Entity> search1(IPage page, @Param("key") String key);
    @Select("SELECT * from donation2  where donater like CONCAT('%',#{key},'%')")
    List<Donation2Entity> search2(IPage page,@Param("key") String key);
}
