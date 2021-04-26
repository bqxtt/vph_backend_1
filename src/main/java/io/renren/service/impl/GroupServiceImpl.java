package io.renren.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.dao.GroupDao;
import io.renren.entity.GroupEntity;
import io.renren.service.GroupService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("groupService")
public class GroupServiceImpl extends ServiceImpl<GroupDao, GroupEntity> implements GroupService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<GroupEntity> page = this.page(
                new Query<GroupEntity>().getPage(params),
                new QueryWrapper<GroupEntity>()
        );

        return new PageUtils(page);
    }

}