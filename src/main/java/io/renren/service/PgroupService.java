package io.renren.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.entity.PgroupEntity;

import java.util.Map;

/**
 * 
 *
 * @author ghw
 * @email 1044386387@qq.com
 * @date 2020-12-21 00:29:24
 */
public interface PgroupService extends IService<PgroupEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

