package io.renren.controller;

import io.renren.entity.GroupEntity;
import io.renren.service.GroupService;
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
@RequestMapping("love/group")
public class GroupController {
    @Autowired
    private GroupService groupService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("love:group:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = groupService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{groupId}")
    //@RequiresPermissions("love:group:info")
    public R info(@PathVariable("groupId") Integer groupId){
		GroupEntity group = groupService.getById(groupId);

        return R.ok().put("group", group);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("love:group:save")
    public R save(@RequestBody GroupEntity group){
		groupService.save(group);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("love:group:update")
    public R update(@RequestBody GroupEntity group){
		groupService.updateById(group);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
   // @RequiresPermissions("love:group:delete")
    public R delete(@RequestBody Integer[] groupIds){
		groupService.removeByIds(Arrays.asList(groupIds));

        return R.ok();
    }

}
