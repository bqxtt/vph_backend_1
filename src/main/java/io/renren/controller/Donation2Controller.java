package io.renren.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.entity.Donation2Entity;
import io.renren.service.Donation2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 
 *
 * @author ghw
 * @email 1044386387@qq.com
 * @date 2020-06-12 20:10:29
 */
@RestController
@RequestMapping("renren/donation2")
public class Donation2Controller {
    @Autowired
    private Donation2Service donation2Service;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("renren:donation2:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = donation2Service.queryPage(params);

        return R.ok().put("page", page);
    }
    @RequestMapping("/search1")
    //@RequiresPermissions("renren:distribution:list")
    public R search1(@RequestParam Map<String, Object> params){
        PageUtils page = donation2Service.queryPage1(params);

        return R.ok().put("page", page);
    }
    @RequestMapping("/search2")
    //@RequiresPermissions("renren:distribution:list")
    public R search2(@RequestParam Map<String, Object> params){
        PageUtils page = donation2Service.queryPage2(params);

        return R.ok().put("page", page);
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("renren:donation2:info")
    public R info(@PathVariable("id") Integer id){
		Donation2Entity donation2 = donation2Service.getById(id);

        return R.ok().put("donation2", donation2);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("renren:donation2:save")
    public R save(@RequestBody Donation2Entity donation2){
		donation2Service.save(donation2);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("renren:donation2:update")
    public R update(@RequestBody Donation2Entity donation2){
		donation2Service.updateById(donation2);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
   // @RequiresPermissions("renren:donation2:delete")
    public R delete(@RequestBody Integer[] ids){
		donation2Service.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
