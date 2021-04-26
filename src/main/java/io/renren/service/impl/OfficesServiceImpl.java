package io.renren.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.dao.OfficesDao;
import io.renren.entity.OfficesEntity;
import io.renren.service.OfficesService;


@Service("officesService")
public class OfficesServiceImpl extends ServiceImpl<OfficesDao, OfficesEntity> implements OfficesService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OfficesEntity> page = this.page(
                new Query<OfficesEntity>().getPage(params),
                new QueryWrapper<OfficesEntity>()
        );

        return new PageUtils(page);
    }

}