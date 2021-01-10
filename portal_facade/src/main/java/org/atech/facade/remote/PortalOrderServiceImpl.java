package org.atech.facade.remote;


import com.google.gson.Gson;
import io.swagger.annotations.ApiOperation;
import org.atech.facade.common.CommonResult;
import org.atech.facade.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import java.util.List;


/**
 * 前台订单管理Service
 * Created by Duwupeng on 2018/8/30.
 */
@Service
public class PortalOrderServiceImpl implements  IPortalOrderRemoteService {
    @Autowired
    private RestTemplate restTemplate;

    @ApiOperation("postForEntity jsonBody")
    @RequestMapping(value = "/post1", method = RequestMethod.POST)
    @ResponseBody
    @Override
    public int add(Order orderParam) {
        String url = HTTP + SERVICE_NAME + "/create";
        CommonResult<Integer> commonResult = restTemplate.postForObject(url, null, CommonResult.class);
        return commonResult.getData();
    }

    @Override
    public int modify(Long id, Order order) {
        String url = HTTP + SERVICE_NAME + "/update/{id}";
        CommonResult<Integer> commonResult = restTemplate.postForObject(url, null, CommonResult.class);
        return commonResult.getData();
    }


    @ApiOperation("postForEntity jsonBody")
    @RequestMapping(value = "/post1", method = RequestMethod.POST)
    @ResponseBody
    @Override
    public Order detail(Long orderId) {
        String url = HTTP + SERVICE_NAME + "/brand/create";
        CommonResult<String> commonResult = restTemplate.postForObject(url, null, CommonResult.class);
        Order order = new Gson().fromJson(commonResult.getData(),Order.class) ;
        return order;

    }

    @Override
    public List<Order> list(Long orderId, int pageSize, int pageNum) {
        String url = HTTP + SERVICE_NAME + "/brand/create";
        CommonResult<List<Order>> commonResult = restTemplate.postForObject(url, null, CommonResult.class);
//        new Gson().fromJson(commonResult.getData(),List.class) ;
//        List<Order> orders = new Gson().fromJson(commonResult.getData(),List.class) ;
        return null;
    }


    @ApiOperation("postForEntity jsonBody")
    @RequestMapping(value = "/post2", method = RequestMethod.POST)
    @ResponseBody
    @Override
    public int delete(Long orderId) {
        String url = HTTP + SERVICE_NAME + "/brand/delete";
        restTemplate.delete(url);
        return 1;
    }
}
