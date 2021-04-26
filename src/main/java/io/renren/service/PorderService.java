package io.renren.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.entity.PorderEntity;

import java.util.Map;

/**
 * 
 *
 * @author ghw
 * @email 1044386387@qq.com
 * @date 2020-12-18 23:09:27
 */
public interface PorderService extends IService<PorderEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryPage1(Map<String, Object> params);
}

