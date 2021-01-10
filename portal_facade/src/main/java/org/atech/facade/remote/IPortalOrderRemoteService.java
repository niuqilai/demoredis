package org.atech.facade.remote;



import org.atech.facade.bo.OrderParam;
import org.atech.facade.domain.Order;

import java.util.List;

/**
 * 前台订单管理Service
 * Created by macro on 2018/8/30.
 */
public interface IPortalOrderRemoteService extends IRemoteService {

    int add(Order order);

    int modify(Long id, Order order);

    Order detail(Long orderId);

    List<Order> list(Long orderId,int pageSize, int pageNum);

    int delete(Long orderId);
}
