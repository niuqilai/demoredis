package org.atech.portal.controller;

import org.atech.facade.bo.RedisCmdParam;
import org.atech.facade.common.CommonResult;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class RedisTransactionCmd {


    private RedisTemplate<String, Object> redisTemplate;

    /*
     * DISCARD  丢弃所有 MULTI 之后发的命令
       EXEC  执行所有 MULTI 之后发的命令
       MULTI  标记一个事务块开始
       UNWATCH  取消事务命令
       WATCH key [key ...]  锁定key直到执行了 MULTI/EXEC 命令
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
