package io.renren.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.dao.TestDao;
import io.renren.entity.TestEntity;
import io.renren.service.TestService;


@Service("testService")
public class TestServiceImpl extends ServiceImpl<TestDao, TestEntity> implements TestService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TestEntity> page = this.page(
                new Query<TestEntity>().getPage(params),
                new QueryWrapper<TestEntity>()
        );

        return new PageUtils(page);
    }

}