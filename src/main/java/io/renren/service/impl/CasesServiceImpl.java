package io.renren.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.dao.CasesDao;
import io.renren.entity.CasesEntity;
import io.renren.service.CasesService;


@Service("casesService")
public class CasesServiceImpl extends ServiceImpl<CasesDao, CasesEntity> implements CasesService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CasesEntity> page = this.page(
                new Query<CasesEntity>().getPage(params),
                new QueryWrapper<CasesEntity>()
        );

        return new PageUtils(page);
    }

}