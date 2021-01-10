package org.atech.facade.domain;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 订单详情信息
 * Created by Duwupeng on 2018/10/11.
 */
public class OrderDetail extends Order {
    @Getter
    @Setter
    @ApiModelProperty("订单商品列表")
    private List<OrderItem> orderItemList;
}
