package io.renren.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.entity.ProjectinfoEntity;

import java.util.Map;

/**
 * 
 *
 * @author ghw
 * @email 1044386387@qq.com
 * @date 2020-12-20 22:37:10
 */
public interface ProjectinfoService extends IService<ProjectinfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

