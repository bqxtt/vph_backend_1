package io.renren.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.entity.DiseasesEntity;

import java.util.Map;

/**
 * 
 *
 * @author ghw
 * @email 1044386387@qq.com
 * @date 2021-04-21 14:21:26
 */
public interface DiseasesService extends IService<DiseasesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

