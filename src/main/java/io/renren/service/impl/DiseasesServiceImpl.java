package io.renren.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.dao.DiseasesDao;
import io.renren.entity.DiseasesEntity;
import io.renren.service.DiseasesService;


@Service("diseasesService")
public class DiseasesServiceImpl extends ServiceImpl<DiseasesDao, DiseasesEntity> implements DiseasesService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<DiseasesEntity> page = this.page(
                new Query<DiseasesEntity>().getPage(params),
                new QueryWrapper<DiseasesEntity>()
        );

        return new PageUtils(page);
    }

}