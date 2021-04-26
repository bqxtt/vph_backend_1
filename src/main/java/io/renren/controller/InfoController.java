package io.renren.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.entity.InfoEntity;
import io.renren.service.InfoService;
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
@RequestMapping("love/info")
public class InfoController {
    @Autowired
    private InfoService infoService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("love:info:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = infoService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("love:info:info")
    public R info(@PathVariable("id") Integer id){
		InfoEntity info = infoService.getById(id);

        return R.ok().put("info", info);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("love:info:save")
    public R save(@RequestBody InfoEntity info){
		infoService.save(info);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("love:info:update")
    public R update(@RequestBody InfoEntity info){
		infoService.updateById(info);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
   // @RequiresPermissions("love:info:delete")
    public R delete(@RequestBody Integer[] ids){
		infoService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
