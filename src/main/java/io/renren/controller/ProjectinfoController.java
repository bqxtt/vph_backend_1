package io.renren.controller;

import io.renren.entity.ProjectinfoEntity;
import io.renren.service.ProjectinfoService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 
 *
 * @author ghw
 * @email 1044386387@qq.com
 * @date 2020-12-20 22:37:10
 */
@RestController
@RequestMapping("love/projectinfo")
public class ProjectinfoController {
    @Autowired
    private ProjectinfoService projectinfoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("love:projectinfo:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = projectinfoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{projectId}")
    //@RequiresPermissions("love:projectinfo:info")
    public R info(@PathVariable("projectId") Integer projectId){
		ProjectinfoEntity projectinfo = projectinfoService.getById(projectId);

        return R.ok().put("projectinfo", projectinfo);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("love:projectinfo:save")
    public R save(@RequestBody ProjectinfoEntity projectinfo){
		projectinfoService.save(projectinfo);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("love:projectinfo:update")
    public R update(@RequestBody ProjectinfoEntity projectinfo){
		projectinfoService.updateById(projectinfo);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
   // @RequiresPermissions("love:projectinfo:delete")
    public R delete(@RequestBody Integer[] projectIds){
		projectinfoService.removeByIds(Arrays.asList(projectIds));

        return R.ok();
    }

}
