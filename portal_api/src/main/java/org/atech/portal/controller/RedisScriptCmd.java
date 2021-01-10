package org.atech.portal.controller;

import org.atech.facade.bo.RedisCmdParam;
import org.atech.facade.common.CommonResult;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class RedisScriptCmd {


    private RedisTemplate<String, Object> redisTemplate;

    /*
     *EVAL script numkeys key [key ...] arg [arg ...]
     * 在服务器端执行 LUA 脚本
     * EVALSHA sha1 numkeys key [key ...] arg [arg ...]
     * 在服务器端执行 LUA 脚本
     * SCRIPT DEBUG YES|SYNC|NO
     * Set the debug mode for executed scripts.
     * SCRIPT EXISTS script [script ...]
     * Check existence of scripts in the script cache.
     * SCRIPT FLUSH
     * 删除服务器缓存中所有Lua脚本。
     * SCRIPT KILL
     * 杀死当前正在运行的 Lua 脚本。
     * SCRIPT LOAD script
     * 从服务器缓存中装载一个Lua脚本。
     *
     * @param redisCmdParam
     * @return
     *
     * 接收前端界面，产生客户化命令
     */
    @RequestMapping(value = "/execCustRedisLua", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult execCustLuaCmds(@Validated @RequestBody RedisCmdParam redisCmdParam) {
        return null;
    }
    @RequestMapping(value = "/execDefaultRedisLua", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult execDefaultLuaCmds(@Validated @RequestBody RedisCmdParam redisCmdParam) {
        return null;
    }
}
