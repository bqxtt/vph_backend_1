package io.renren.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.dao.PorderDao;
import io.renren.entity.PorderEntity;
import io.renren.service.PorderService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("porderService")
public class PorderServiceImpl extends ServiceImpl<PorderDao, PorderEntity> implements PorderService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PorderEntity> page = this.page(
                new Query<PorderEntity>().getPage(params),
                new QueryWrapper<PorderEntity>()
        );


        return new PageUtils(page);
    }
    public PageUtils queryPage1(Map<String, Object> params) {
        IPage<PorderEntity> page = this.page(
                new Query<PorderEntity>().getPage(params),
                new QueryWrapper<PorderEntity>()
        );
        String username=(String)params.get("username");
        System.out.println(username);
        if(!username.equals("admin1"))
        {System.out.println("rightr");
        page.setRecords(this.baseMapper.search1(page,username));}
        return new PageUtils(page);
    }
}