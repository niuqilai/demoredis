package org.atech.portal.controller;

import org.atech.facade.bo.RedisCmdParam;
import org.atech.facade.common.CommonResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class RedisHyperloglogCmd {

    /*
     *
       PFADD key element [element ...]             将指定元素添加到HyperLogLog
       PFCOUNT key [key ...]                       Return the approximated cardinality of the set(s) observed by the HyperLogLog at key(s).
       PFMERGE destkey sourcekey [sourcekey ...]   Merge N different HyperLogLogs into a single one.
     * @param redisCmdParam
     * @return
     */
    @RequestMapping(value = "/execCustRedisHyperloglog", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult execCustHyperloglogCmds(@Validated @RequestBody RedisCmdParam redisCmdParam) {
        return null;
    }
    @RequestMapping(value = "/execDefaultRedisHyperloglog", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult execDefaultHyperloglogCmds(@Validated @RequestBody RedisCmdParam redisCmdParam) {
        return null;
    }
}
