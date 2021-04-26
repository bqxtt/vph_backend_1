package io.renren.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.entity.Donation2Entity;

import java.util.Map;

/**
 * 
 *
 * @author ghw
 * @email 1044386387@qq.com
 * @date 2020-06-12 20:10:29
 */
public interface Donation2Service extends IService<Donation2Entity> {

    PageUtils queryPage(Map<String, Object> params);
    PageUtils queryPage1(Map<String, Object> params);
    PageUtils queryPage2(Map<String, Object> params);
}

