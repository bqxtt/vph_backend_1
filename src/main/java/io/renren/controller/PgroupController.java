package io.renren.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.entity.PgroupEntity;
import io.renren.service.PgroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 
 *
 * @author ghw
 * @email 1044386387@qq.com
 * @date 2020-12-21 00:29:24
 */
@RestController
@RequestMapping("love/pgroup")
public class PgroupController {
    @Autowired
    private PgroupService pgroupService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("love:pgroup:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = pgroupService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{groupId}")
    //@RequiresPermissions("love:pgroup:info")
    public R info(@PathVariable("groupId") Integer groupId){
		PgroupEntity pgroup = pgroupService.getById(groupId);

        return R.ok().put("pgroup", pgroup);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("love:pgroup:save")
    public R save(@RequestBody PgroupEntity pgroup){
		pgroupService.save(pgroup);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("love:pgroup:update")
    public R update(@RequestBody PgroupEntity pgroup){
		pgroupService.updateById(pgroup);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
   // @RequiresPermissions("love:pgroup:delete")
    public R delete(@RequestBody Integer[] groupIds){
		pgroupService.removeByIds(Arrays.asList(groupIds));

        return R.ok();
    }

}
