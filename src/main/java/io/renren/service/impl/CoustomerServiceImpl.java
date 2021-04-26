package io.renren.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.dao.CoustomerDao;
import io.renren.entity.CoustomerEntity;
import io.renren.service.CoustomerService;


@Service("coustomerService")
public class CoustomerServiceImpl extends ServiceImpl<CoustomerDao, CoustomerEntity> implements CoustomerService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CoustomerEntity> page = this.page(
                new Query<CoustomerEntity>().getPage(params),
                new QueryWrapper<CoustomerEntity>()
        );

        return new PageUtils(page);
    }

}