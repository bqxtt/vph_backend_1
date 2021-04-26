package io.renren.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.dao.AccountDao;
import io.renren.dao.FlightDao;
import io.renren.dao.PorderDao;
import io.renren.entity.PorderEntity;
import io.renren.service.PorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileWriter;
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
@RequestMapping("love/porder")
public class PorderController {
    @Autowired
    private PorderService porderService;
    @Autowired private PorderDao porderDao;
    @Autowired
    private AccountDao accountDao;
    @Autowired FlightDao flightDao;

    /**
     * 列表
     */
    @RequestMapping("/list")
    //@RequiresPermissions("love:porder:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = porderService.queryPage1(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    //@RequiresPermissions("love:porder:info")
    public R info(@PathVariable("id") Integer id){
		PorderEntity porder = porderService.getById(id);

        return R.ok().put("porder", porder);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("love:porder:save")
    public R save(@RequestBody PorderEntity porder){
        Double newprice=0.0;
        Integer flightId=porder.getFlightId();
        Integer accountId=porder.getAccountId();
        if(porderDao.hasThisFlightId(flightId)==0)
            return R.error("无此航班号");
        if(porder.getPrice()==-1)
        {switch (porder.getSeatType())
        {
            case 1:  newprice=porderDao.getPriceByFlightId1(flightId);
            flightDao.subseat1(flightId,1);
            break;
            case 2:  newprice=porderDao.getPriceByFlightId2(flightId);
                flightDao.subseat2(flightId,1);
                break;
            case 3:  newprice=porderDao.getPriceByFlightId3(flightId);
                flightDao.subseat3(flightId,1);
                break;
            default: return R.error("无此种航班类型");
        }
        accountDao.subbalance(accountId,newprice);

        porder.setPrice(newprice);

        }
		porderService.save(porder);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("love:porder:update")
    public R update(@RequestBody PorderEntity porder){
		porderService.updateById(porder);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
   // @RequiresPermissions("love:porder:delete")
    public R delete(@RequestBody Integer[] ids){
       // return R.ok();
        for(Integer orderid:ids){
            Double newprice=0.0;
            PorderEntity porder=porderDao.selcetPorderById(orderid);
            Integer flightId=porder.getFlightId();
            Integer accountId=porder.getAccountId();
            switch (porder.getSeatType())
            {
                case 1:  newprice=porderDao.getPriceByFlightId1(flightId);
                    flightDao.addseat1(flightId,1);
                    break;
                case 2:  newprice=porderDao.getPriceByFlightId2(flightId);
                    flightDao.addseat2(flightId,1);
                    break;
                case 3:  newprice=porderDao.getPriceByFlightId3(flightId);
                    flightDao.addseat3(flightId,1);
                    break;
                default: return R.error("无此种航班类型");
            }
                accountDao.addbalance(accountId,newprice);

                porder.setPrice(newprice);

            }
        porderService.removeByIds(Arrays.asList(ids));


            return R.ok();
        }



}
