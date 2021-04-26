package io.renren.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.dao.Donation2Dao;
import io.renren.entity.Donation2Entity;
import io.renren.service.Donation2Service;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("donation2Service")
public class Donation2ServiceImpl extends ServiceImpl<Donation2Dao, Donation2Entity> implements Donation2Service {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<Donation2Entity> page = this.page(
                new Query<Donation2Entity>().getPage(params),
                new QueryWrapper<Donation2Entity>()
        );

        return new PageUtils(page);
    }
    public PageUtils queryPage1(Map<String, Object> params) {
        IPage<Donation2Entity> page = this.page(
                new Query<Donation2Entity>().getPage(params),
                new QueryWrapper<Donation2Entity>()
        );
        page.setRecords(this.baseMapper.search1(page,(String)params.get("key")));
        return new PageUtils(page);
    }
    public PageUtils queryPage2(Map<String, Object> params) {
        IPage<Donation2Entity> page = this.page(
                new Query<Donation2Entity>().getPage(params),
                new QueryWrapper<Donation2Entity>()
        );
        page.setRecords(this.baseMapper.search2(page,(String)params.get("key")));
        return new PageUtils(page);
    }

}