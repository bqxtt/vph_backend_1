package io.renren.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.entity.CasesEntity;
import io.renren.service.CasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 
 *
 * @author ghw
 * @email 1044386387@qq.com
 * @date 2021-04-21 14:21:26
 */
@RestController
@RequestMapping("love/cases")
public class CasesController {
    @Autowired
    private CasesService casesService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("love:cases:list")
    public R list(@RequestParam Map<String, Object> params){

        System.out.println("list cases: " + params);
        PageUtils page = casesService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("love:cases:info")
    public R info(@PathVariable("id") Integer id){
		CasesEntity cases = casesService.getById(id);

        return R.ok().put("cases", cases);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("love:cases:save")
    public R save(@RequestBody CasesEntity cases){
		casesService.save(cases);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("love:cases:update")
    public R update(@RequestBody CasesEntity cases){
		casesService.updateById(cases);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
   // @RequiresPermissions("love:cases:delete")
    public R delete(@RequestBody Integer[] ids){
		casesService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
