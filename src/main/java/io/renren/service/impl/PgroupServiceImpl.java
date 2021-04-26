package io.renren.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.dao.PgroupDao;
import io.renren.entity.PgroupEntity;
import io.renren.service.PgroupService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("pgroupService")
public class PgroupServiceImpl extends ServiceImpl<PgroupDao, PgroupEntity> implements PgroupService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PgroupEntity> page = this.page(
                new Query<PgroupEntity>().getPage(params),
                new QueryWrapper<PgroupEntity>()
        );

        return new PageUtils(page);
    }

}