package org.atech.portal.controller;

import cn.hutool.core.bean.BeanUtil;
//import com.alibaba.csp.sentinel.annotation.SentinelResource;
//import com.alibaba.csp.sentinel.slots.block.BlockException;
import io.swagger.annotations.ApiOperation;
import org.atech.facade.bo.OrderParam;
import org.atech.facade.common.CommonPage;
import org.atech.facade.common.CommonResult;
import org.atech.facade.domain.Order;
import org.atech.facade.remote.IPortalOrderRemoteService;
import org.atech.portal.mq.MqProducer;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PortalOrderController {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(PortalOrderController.class);

    @Autowired
    IPortalOrderRemoteService portalOrderRemoteService;

//    @SentinelResource(value = "/create}", blockHandler = "blockHandlerPortalOrderCreate")
    @ApiOperation("创建订单")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult index(@Validated @RequestBody OrderParam orderParam) {
        Order order= new Order();
        BeanUtil.copyProperties(orderParam, order);

        int count = portalOrderRemoteService.add(order);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }

    }
//    public String blockHandlerPortalOrderCreate(BlockException e) {
//        return "限流";
//    }
    @ApiOperation("更新订单")
    @RequestMapping(value="/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult modify(@PathVariable Long id,
                        @Validated
                        @RequestBody OrderParam orderParam) {
        Order order= new Order();
        BeanUtil.copyProperties(orderParam, order);
        order.setId(id);
        int count = portalOrderRemoteService.modify(id,order);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("查询订单")
    @RequestMapping("/order/query")
    @ResponseBody
    public Order query(@RequestAttribute Long id) {
        return portalOrderRemoteService.detail(id);
    }

    @ApiOperation("删除订单")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long id) {
        int count = portalOrderRemoteService.delete(id);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }

    }
    @ApiOperation("查询订单列表")
    @RequestMapping(value = "/list/{parentId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<OrderParam>> getList(@PathVariable Long parentId,
                            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<Order> orderList = portalOrderRemoteService.list(parentId, pageSize, pageNum);
        List<OrderParam> orderLists = null;
        return CommonResult.success(CommonPage.restPage(orderLists));
    }

//    @Autowired
//    MqProducer mqProducer;
//    @ApiOperation("发送消息")
//    @RequestMapping("/msg")
//    @ResponseBody
//    public void msg() {
//        log.debug("sneding msg");
//        mqProducer.sendMsg("newTopic","1");
//    }
}
