package org.atech.dbi.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.atech.dbi.mapper.MyPage;
import org.atech.dbi.mapper.PortalOrderMapper;
import org.atech.dbi.service.cache.RedisService;
import org.atech.facade.domain.Order;
import org.atech.dbi.service.PortalOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 前台订单管理Service
 * Created by Duwupeng on 2018/8/30.
 */
@Service
public class PortalOrderDbiServiceImpl extends ServiceImpl<PortalOrderMapper, Order> implements IPortalOrderService,  PortalOrderService {


    @Autowired
    private PortalOrderMapper portalOrderMapper;

    @Autowired
    RedisService redisService;

    @Override
    public int add(Order orderParam) {
        return portalOrderMapper.insert(orderParam);
    }

    @Override
    public int modify(Long orderId, Order orderParam) {
        return portalOrderMapper.updateById(orderParam);
    }

    @Override
    public Order detail(Long orderId) {
        Order order = portalOrderMapper.selectById(orderId);
        redisService.set(orderId+"", order);
        return order;
    }

    @Override
    public List<Order> list(Long payType, int pageSize, int pageNum) {
        MyPage<Order> page=new MyPage<Order>(pageNum,pageSize);
        page = portalOrderMapper.mySelectPage(page);
        return page.getRecords();
    }

    @Override
    public int delete(Long orderId) {
        return portalOrderMapper.deleteById(orderId);
    }


}
