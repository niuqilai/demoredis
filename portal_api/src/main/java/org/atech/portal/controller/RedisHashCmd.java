package org.atech.portal.controller;

import org.atech.facade.bo.RedisCmdParam;
import org.atech.facade.common.CommonResult;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class RedisHashCmd {


    private RedisTemplate<String, Object> redisTemplate;

    /*
     * HDEL key field [field ...]                          删除一个或多个Hash的field
     * HEXISTS key field                                   判断field是否存在于hash中
     * HGET key field                                      获取hash中field的值
     * HGETALL key                                         从hash中读取全部的域和值
     * HINCRBY key field increment                         将hash中指定域的值增加给定的数字
     * HINCRBYFLOAT key field increment                    将hash中指定域的值增加给定的浮点数
     * HKEYS key                                           获取hash的所有字段
     * HLEN key                                            获取hash里所有字段的数量
     * HMGET key field [field ...]                         获取hash里面指定字段的值
     * HMSET key field value [field value ...]             设置hash字段值
     * HSET key field value                                设置hash里面一个字段的值
     * HSETNX key field value                              设置hash的一个字段，只有当这个字段不存在时有效
     * HSTRLEN key field                                   获取hash里面指定field的长度
     * HVALS key                                           获得hash的所有值
     * HSCAN key cursor [MATCH pattern] [COUNT count]      迭代hash里面的元素
     *
     * @param redisCmdParam
     * @return
     *
     * 接收前端界面，产生客户化命令
     */
    @RequestMapping(value = "/execCustRedisHash", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult execCustHashCmds(@Validated @RequestBody RedisCmdParam redisCmdParam) {
        //
        return null;
    }
    @RequestMapping(value = "/execDefaultRedisHash", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult execDefaultHashCmds(@Validated @RequestBody RedisCmdParam redisCmdParam) {

        return null;
    }
}
