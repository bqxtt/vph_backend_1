package io.renren.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.entity.TestEntity;
import io.renren.service.TestService;
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
@RequestMapping("love/test")
public class TestController {
    @Autowired
    private TestService testService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("love:test:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = testService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("love:test:info")
    public R info(@PathVariable("id") Integer id){
		TestEntity test = testService.getById(id);

        return R.ok().put("test", test);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("love:test:save")
    public R save(@RequestBody TestEntity test){
		testService.save(test);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("love:test:update")
    public R update(@RequestBody TestEntity test){
		testService.updateById(test);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
   // @RequiresPermissions("love:test:delete")
    public R delete(@RequestBody Integer[] ids){
		testService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
