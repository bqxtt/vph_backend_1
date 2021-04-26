package io.renren.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.dao.ProjectinfoDao;
import io.renren.entity.ProjectinfoEntity;
import io.renren.service.ProjectinfoService;


@Service("projectinfoService")
public class ProjectinfoServiceImpl extends ServiceImpl<ProjectinfoDao, ProjectinfoEntity> implements ProjectinfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProjectinfoEntity> page = this.page(
                new Query<ProjectinfoEntity>().getPage(params),
                new QueryWrapper<ProjectinfoEntity>()
        );

        return new PageUtils(page);
    }

}