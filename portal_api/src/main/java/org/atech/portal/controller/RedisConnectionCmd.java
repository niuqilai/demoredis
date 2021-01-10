package org.atech.portal.controller;

import org.atech.facade.bo.RedisCmdParam;
import org.atech.facade.common.CommonResult;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class RedisConnectionCmd {


    private RedisTemplate<String, Object> redisTemplate;

    /*
     * AUTH password   验证服务器命令
       ECHO message   回显输入的字符串
       PING           Ping 服务器
       QUIT           关闭连接，退出
       SELECT index   选择新数据库
       SWAPDB index index   Swaps two Redis databases
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
