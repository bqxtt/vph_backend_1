package io.renren.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.entity.AccountEntity;
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
public interface AccountDao extends BaseMapper<AccountEntity> {
    @Update("update account set  balance=balance-#{balanceGap} where id = #{accountId}")
    void subbalance( @Param("accountId") Integer accountId,@Param("balanceGap") Double balanceGap);
    @Update("update account set  balance=balance+#{balanceGap} where id = #{accountId}")
    void addbalance( @Param("accountId") Integer accountId,@Param("balanceGap") Double balanceGap);
	
}
