package io.renren.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.dao.PlaneDao;
import io.renren.entity.PlaneEntity;
import io.renren.service.PlaneService;


@Service("planeService")
public class PlaneServiceImpl extends ServiceImpl<PlaneDao, PlaneEntity> implements PlaneService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PlaneEntity> page = this.page(
                new Query<PlaneEntity>().getPage(params),
                new QueryWrapper<PlaneEntity>()
        );

        return new PageUtils(page);
    }

}