package io.renren.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.entity.DiseasesEntity;
import io.renren.service.DiseasesService;
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
@RequestMapping("love/diseases")
public class DiseasesController {
    @Autowired
    private DiseasesService diseasesService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("love:diseases:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = diseasesService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("love:diseases:info")
    public R info(@PathVariable("id") Integer id){
		DiseasesEntity diseases = diseasesService.getById(id);

        return R.ok().put("diseases", diseases);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("love:diseases:save")
    public R save(@RequestBody DiseasesEntity diseases){
		diseasesService.save(diseases);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("love:diseases:update")
    public R update(@RequestBody DiseasesEntity diseases){
		diseasesService.updateById(diseases);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
   // @RequiresPermissions("love:diseases:delete")
    public R delete(@RequestBody Integer[] ids){
		diseasesService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
