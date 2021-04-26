package io.renren.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.entity.CoustomerEntity;
import io.renren.service.CoustomerService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author ghw
 * @email 1044386387@qq.com
 * @date 2020-12-18 23:09:27
 */
@RestController
@RequestMapping("love/coustomer")
public class CoustomerController {
    @Autowired
    private CoustomerService coustomerService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("love:coustomer:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = coustomerService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("love:coustomer:info")
    public R info(@PathVariable("id") Integer id){
		CoustomerEntity coustomer = coustomerService.getById(id);

        return R.ok().put("coustomer", coustomer);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("love:coustomer:save")
    public R save(@RequestBody CoustomerEntity coustomer){
		coustomerService.save(coustomer);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("love:coustomer:update")
    public R update(@RequestBody CoustomerEntity coustomer){
		coustomerService.updateById(coustomer);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
   // @RequiresPermissions("love:coustomer:delete")
    public R delete(@RequestBody Integer[] ids){
		coustomerService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
