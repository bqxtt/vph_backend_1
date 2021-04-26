package io.renren.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.dao.DistributionDao;
import io.renren.entity.DistributionEntity;
import io.renren.service.DistributionService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("distributionService")
public class DistributionServiceImpl extends ServiceImpl<DistributionDao, DistributionEntity> implements DistributionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DistributionEntity> page = this.page(
                new Query<DistributionEntity>().getPage(params),
                new QueryWrapper<DistributionEntity>()
        );

        return new PageUtils(page);
    }
    public PageUtils queryPage1(Map<String, Object> params) {
        IPage<DistributionEntity> page = this.page(
                new Query<DistributionEntity>().getPage(params),
                new QueryWrapper<DistributionEntity>()
        );
page.setRecords(this.baseMapper.search1(page,(String)params.get("key")));
        return new PageUtils(page);
    }
    public PageUtils queryPage2(Map<String, Object> params) {
        IPage<DistributionEntity> page = this.page(
                new Query<DistributionEntity>().getPage(params),
                new QueryWrapper<DistributionEntity>()
        );
        page.setRecords(this.baseMapper.search2(page,(String)params.get("key")));
        return new PageUtils(page);
    }

}