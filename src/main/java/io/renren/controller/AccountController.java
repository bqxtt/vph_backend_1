package io.renren.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.entity.AccountEntity;
import io.renren.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 
 *
 * @author ghw
 * @email 1044386387@qq.com
 * @date 2020-12-18 23:09:27
 */
@RestController
@RequestMapping("love/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("love:account:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = accountService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("love:account:info")
    public R info(@PathVariable("id") Integer id){
		AccountEntity account = accountService.getById(id);

        return R.ok().put("account", account);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("love:account:save")
    public R save(@RequestBody AccountEntity account){
		accountService.save(account);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("love:account:update")
    public R update(@RequestBody AccountEntity account){
		accountService.updateById(account);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
   // @RequiresPermissions("love:account:delete")
    public R delete(@RequestBody Integer[] ids){
		accountService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
