package org.atech.portal.controller;

import org.atech.facade.bo.RedisCmdParam;
import org.atech.facade.common.CommonResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class RedisSetsCmd {

    /*
     *
     * SADD key member [member ...]         添加一个或者多个元素到集合(set)里
     * SCARD key                            获取集合里面的元素数量
     * SDIFF key [key ...]                  获得队列不存在的元素
     * SDIFFSTORE destination key [key ...]  获得队列不存在的元素，并存储在一个关键的结果集
     * SINTER key [key ...]                  获得两个集合的交集
     * SINTERSTORE destination key [key ...]  获得两个集合的交集，并存储在一个关键的结果集
     * SISMEMBER key member                   确定一个给定的值是一个集合的成员
     * SMEMBERS key                           获取集合里面的所有元素
     * SMOVE source destination member        移动集合里面的一个元素到另一个集合
     * SPOP key [count]                       删除并获取一个集合里面的元素
     * SRANDMEMBER key [count]                从集合里面随机获取一个元素
     * SREM key member [member ...]           从集合里删除一个或多个元素
     * SUNION key [key ...]                   添加多个set元素
     * SUNIONSTORE destination key [key ...]  合并set元素，并将结果存入新的set里面
     * SSCAN key cursor [MATCH pattern] [COUNT count]  迭代set里面的元素
     * @param redisCmdParam
     * @return
     */
    @RequestMapping(value = "/execCustRedisSet", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult execCustRedisSetCmds(@Validated @RequestBody RedisCmdParam redisCmdParam) {
        return null;
    }
    @RequestMapping(value = "/execDefaultRedisSet", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult execDefaultRedisSetCmds(@Validated @RequestBody RedisCmdParam redisCmdParam) {
        return null;
    }


}
