package io.renren.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.dao.FlightDao;
import io.renren.entity.FlightEntity;
import io.renren.service.FlightService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("flightService")
public class FlightServiceImpl extends ServiceImpl<FlightDao, FlightEntity> implements FlightService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<FlightEntity> page = this.page(
                new Query<FlightEntity>().getPage(params),
                new QueryWrapper<FlightEntity>()
        );

        return new PageUtils(page);
    }

}