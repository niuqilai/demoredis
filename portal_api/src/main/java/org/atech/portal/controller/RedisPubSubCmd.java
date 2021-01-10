package org.atech.portal.controller;

import org.atech.facade.bo.RedisCmdParam;
import org.atech.facade.common.CommonResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class RedisPubSubCmd {

    /*
     *
     * PSUBSCRIBE pattern [pattern ...]              Listen for messages published to channels matching the given patterns
     * PUBSUB subcommand [argument [argument ...]]   Inspect the state of the Pub/Sub subsystem
     * PUBLISH channel message                      发布一条消息到频道
     * PUNSUBSCRIBE [pattern [pattern ...]]         停止发布到匹配给定模式的渠道的消息听
     * SUBSCRIBE channel [channel ...]              监听频道发布的消息
     * UNSUBSCRIBE [channel [channel ...]]          停止频道监听
     * @param redisCmdParam
     * @return
     */
    @RequestMapping(value = "/execCustRedisPubSub", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult execCustPubSubCmds(@Validated @RequestBody RedisCmdParam redisCmdParam) {
        return null;
    }
    @RequestMapping(value = "/execDefaultRedisPubSub", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult execDefaultPubSubCmds(@Validated @RequestBody RedisCmdParam redisCmdParam) {
        return null;
    }
}
