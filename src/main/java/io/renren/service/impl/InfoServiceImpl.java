package io.renren.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.dao.InfoDao;
import io.renren.entity.InfoEntity;
import io.renren.service.InfoService;


@Service("infoService")
public class InfoServiceImpl extends ServiceImpl<InfoDao, InfoEntity> implements InfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<InfoEntity> page = this.page(
                new Query<InfoEntity>().getPage(params),
                new QueryWrapper<InfoEntity>()
        );

        return new PageUtils(page);
    }

}