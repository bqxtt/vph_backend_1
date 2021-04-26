package io.renren.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.entity.PlaneEntity;

import java.util.Map;

/**
 * 
 *
 * @author ghw
 * @email 1044386387@qq.com
 * @date 2020-12-18 23:09:27
 */
public interface PlaneService extends IService<PlaneEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

