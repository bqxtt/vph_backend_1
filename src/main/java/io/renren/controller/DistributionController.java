package io.renren.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.entity.DistributionEntity;
import io.renren.service.DistributionService;
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
@RequestMapping("renren/distribution")
public class DistributionController {
    @Autowired
    private DistributionService distributionService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("renren:distribution:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = distributionService.queryPage(params);

        return R.ok().put("page", page);
    }
    @RequestMapping("/search1")
    //@RequiresPermissions("renren:distribution:list")
    public R search1(@RequestParam Map<String, Object> params){
        PageUtils page = distributionService.queryPage1(params);

        return R.ok().put("page", page);
    }
    @RequestMapping("/search2")
    //@RequiresPermissions("renren:distribution:list")
    public R search2(@RequestParam Map<String, Object> params){
        PageUtils page = distributionService.queryPage2(params);

        return R.ok().put("page", page);
    }
    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("renren:distribution:info")
    public R info(@PathVariable("id") Integer id){
		DistributionEntity distribution = distributionService.getById(id);

        return R.ok().put("distribution", distribution);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("renren:distribution:save")
    public R save(@RequestBody DistributionEntity distribution){
		distributionService.save(distribution);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("renren:distribution:update")
    public R update(@RequestBody DistributionEntity distribution){
		distributionService.updateById(distribution);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
   // @RequiresPermissions("renren:distribution:delete")
    public R delete(@RequestBody Integer[] ids){
		distributionService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
