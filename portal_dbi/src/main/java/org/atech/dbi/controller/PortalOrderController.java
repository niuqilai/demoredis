package org.atech.dbi.controller;


import cn.hutool.core.bean.BeanUtil;
//import com.alibaba.csp.sentinel.annotation.SentinelResource;
//import com.alibaba.csp.sentinel.slots.block.BlockException;
import io.swagger.annotations.ApiOperation;
import org.atech.dbi.service.impl.PortalOrderDbiServiceImpl;
import org.atech.facade.bo.OrderParam;
import org.atech.facade.common.CommonPage;
import org.atech.facade.common.CommonResult;
import org.atech.facade.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class PortalOrderController {

    @Autowired
    PortalOrderDbiServiceImpl portalOrderService;

    @ApiOperation("创建订单")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@Validated @RequestBody OrderParam orderParam) {
        Order order= new Order();
        BeanUtil.copyProperties(orderParam, order);
        order.setCreateTime(new Date());
        order.setModifyTime(new Date());
        int count = portalOrderService.add(order);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }

    }
    @ApiOperation("更新订单")
    @RequestMapping(value="/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult modify(@PathVariable Long id,
                               @Validated
                               @RequestBody OrderParam orderParam) {
        Order order= new Order();
        BeanUtil.copyProperties(orderParam, order);
        order.setId(id);
        int count = portalOrderService.modify(id,order);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("查询订单")
    @RequestMapping("/query/{id}")
    @ResponseBody
    public Order query(@PathVariable Long id) {
        Order order = portalOrderService.detail(id);
        return order;

//        return portalOrderService.detail(id);
    }

    @ApiOperation("删除订单")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        int count = portalOrderService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }

    }
    @ApiOperation("查询订单列表")
    @RequestMapping(value = "/list/{payType}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<Order>> getList(@PathVariable Long payType,
                                                        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<Order> orderList = portalOrderService.list(payType,  pageNum,pageSize);
        return CommonResult.success(CommonPage.restPage(orderList));
    }

}
