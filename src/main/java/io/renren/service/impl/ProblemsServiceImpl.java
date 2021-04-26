package io.renren.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.dao.ProblemsDao;
import io.renren.entity.ProblemsEntity;
import io.renren.service.ProblemsService;


@Service("problemsService")
public class ProblemsServiceImpl extends ServiceImpl<ProblemsDao, ProblemsEntity> implements ProblemsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProblemsEntity> page = this.page(
                new Query<ProblemsEntity>().getPage(params),
                new QueryWrapper<ProblemsEntity>()
        );

        return new PageUtils(page);
    }

}