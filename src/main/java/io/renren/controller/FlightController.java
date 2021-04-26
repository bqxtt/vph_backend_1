package io.renren.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.entity.FlightEntity;
import io.renren.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 
 *
 * @author ghw
 * @email 1044386387@qq.com
 * @date 2020-12-18 23:09:27
 */
@RestController
@RequestMapping("love/flight")
public class FlightController {
    @Autowired
    private FlightService flightService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("love:flight:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = flightService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("love:flight:info")
    public R info(@PathVariable("id") Integer id){
		FlightEntity flight = flightService.getById(id);

        return R.ok().put("flight", flight);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("love:flight:save")
    public R save(@RequestBody FlightEntity flight){
		flightService.save(flight);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("love:flight:update")
    public R update(@RequestBody FlightEntity flight){
		flightService.updateById(flight);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
   // @RequiresPermissions("love:flight:delete")
    public R delete(@RequestBody Integer[] ids){
		flightService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
