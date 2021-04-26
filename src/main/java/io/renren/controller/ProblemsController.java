package io.renren.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.entity.ProblemsEntity;
import io.renren.service.ProblemsService;
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
@RequestMapping("love/problems")
public class ProblemsController {
    @Autowired
    private ProblemsService problemsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("love:problems:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = problemsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("love:problems:info")
    public R info(@PathVariable("id") Integer id){
		ProblemsEntity problems = problemsService.getById(id);

        return R.ok().put("problems", problems);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("love:problems:save")
    public R save(@RequestBody ProblemsEntity problems){
		problemsService.save(problems);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("love:problems:update")
    public R update(@RequestBody ProblemsEntity problems){
		problemsService.updateById(problems);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
   // @RequiresPermissions("love:problems:delete")
    public R delete(@RequestBody Integer[] ids){
		problemsService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
