package io.renren.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.entity.PlaneEntity;
import io.renren.service.PlaneService;
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
@RequestMapping("love/plane")
public class PlaneController {
    @Autowired
    private PlaneService planeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("love:plane:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = planeService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("love:plane:info")
    public R info(@PathVariable("id") Integer id){
		PlaneEntity plane = planeService.getById(id);

        return R.ok().put("plane", plane);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("love:plane:save")
    public R save(@RequestBody PlaneEntity plane){
		planeService.save(plane);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("love:plane:update")
    public R update(@RequestBody PlaneEntity plane){
		planeService.updateById(plane);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
   // @RequiresPermissions("love:plane:delete")
    public R delete(@RequestBody Integer[] ids){
		planeService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
