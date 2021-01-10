package org.atech.portal.controller;

import org.atech.facade.bo.RedisCmdParam;
import org.atech.facade.common.CommonResult;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class RedisStringCmd {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /*
     *INCRBY key increment                                   执行原子增加一个整数
     *INCRBYFLOAT key increment                              执行原子增加一个浮点数
     *MGET key [key ...]                                     获得所有key的值
     *MSET key value [key value ...]                         设置多个key value
     *MSETNX key value [key value ...]                       设置多个key value,仅当key存在时
     *PSETEX key milliseconds value                          Set the value and expiration in milliseconds of a key
     *SET key value [EX seconds] [PX milliseconds] [NX|XX]   设置一个key的value值
     *SETBIT key offset value                                Sets or clears the bit at offset in the string value stored at key
     *SETEX key seconds value                                设置key-value并设置过期时间（单位：秒）
     *SETNX key value                                        设置的一个关键的价值，只有当该键不存在
     *SETRANGE key offset value                              Overwrite part of a string at key starting at the specified offset
     *STRLEN key                                             获取指定key值的长度
     *
     * @param redisCmdParam
     * @return
     *
     * 接收前端界面，产生客户化命令
     */
    @RequestMapping(value = "/execCustRedisString", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult execCustStringCmds(@Validated @RequestBody RedisCmdParam redisCmdParam) {
        System.out.println(11);
        redisTemplate.opsForHash().put("hashkey", redisCmdParam.getOrderSn(),redisCmdParam.getPayType() );
        return null;
    }
    @RequestMapping(value = "/execDefaultRedisString", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult execDefaultStringCmds(@Validated @RequestBody RedisCmdParam redisCmdParam) {
        return null;
    }
}
