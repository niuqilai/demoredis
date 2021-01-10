package org.atech.portal.controller;

import org.atech.facade.bo.RedisCmdParam;
import org.atech.facade.common.CommonResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class RedisListCmd {

    /*
     *
     * BLPOP key [key ...] timeout             删除，并获得该列表中的第一元素，或阻塞，直到有一个可用
     * BRPOP key [key ...] timeout             删除，并获得该列表中的最后一个元素，或阻塞，直到有一个可用
     * BRPOPLPUSH source destination timeout   弹出一个列表的值，将它推到另一个列表，并返回它;或阻塞，直到有一个可用
     * LINDEX key index                        获取一个元素，通过其索引列表
     * LINSERT key BEFORE|AFTER pivot value    在列表中的另一个元素之前或之后插入一个元素
     * LLEN key                                获得队列(List)的长度
     * LPOP key                                从队列的左边出队一个元素
     * LPUSH key value [value ...]             从队列的左边入队一个或多个元素
     * LPUSHX key value                        当队列存在时，从队到左边入队一个元素
     * LRANGE key start stop                   从列表中获取指定返回的元素
     * LREM key count value                    从列表中删除元素
     * LSET key index value                    设置队列里面一个元素的值
     * LTRIM key start stop                    修剪到指定范围内的清单
     * RPOP key                                从队列的右边出队一个元
     * RPOPLPUSH source destination            删除列表中的最后一个元素，将其追加到另一个列表
     * RPUSH key value [value ...]             从队列的右边入队一个元素
     * RPUSHX key value                        从队列的右边入队一个元素，仅队列存在时有效
     * @param redisCmdParam
     * @return
     */
    @RequestMapping(value = "/execCustRedisList", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult execCustListCmds(@Validated @RequestBody RedisCmdParam redisCmdParam) {
        return null;
    }
    @RequestMapping(value = "/execDefaultRedisList", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult execDefaultListCmds(@Validated @RequestBody RedisCmdParam redisCmdParam) {
        return null;
    }


}
