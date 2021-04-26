package io.renren.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.entity.OfficesEntity;
import io.renren.service.OfficesService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author ghw
 * @email 1044386387@qq.com
 * @date 2021-04-21 14:21:26
 */
@RestController
@RequestMapping("love/offices")
public class OfficesController {
    @Autowired
    private OfficesService officesService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("love:offices:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = officesService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("love:offices:info")
    public R info(@PathVariable("id") Integer id){
		OfficesEntity offices = officesService.getById(id);

        return R.ok().put("offices", offices);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("love:offices:save")
    public R save(@RequestBody OfficesEntity offices){
		officesService.save(offices);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("love:offices:update")
    public R update(@RequestBody OfficesEntity offices){
		officesService.updateById(offices);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
   // @RequiresPermissions("love:offices:delete")
    public R delete(@RequestBody Integer[] ids){
		officesService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
