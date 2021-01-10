package org.atech.portal.controller;

import org.atech.facade.bo.RedisCmdParam;
import org.atech.facade.common.CommonResult;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class RedisStreamCmd {


    private RedisTemplate<String, Object> redisTemplate;

   /*
     *
     * XACK key group ID [ID ...]
Marks a pending message as correctly processed, effectively removing it from the pending entries list of the consumer group. Return value of the command is the number of messages successfully acknowledged, that is, the IDs we were actually able to resolve in the PEL.

* XADD key ID field string [field string ...]
Appends a new entry to a stream

* XCLAIM key group consumer min-idle-time ID [ID ...] [IDLE ms] [TIME ms-unix-time] [RETRYCOUNT count] [FORCE] [JUSTID]
Changes (or acquires) ownership of a message in a consumer group, as if the message was delivered to the specified consumer.

* XDEL key ID [ID ...]
Removes the specified entries from the stream. Returns the number of items actually deleted, that may be different from the number of IDs passed in case certain IDs do not exist.

* XGROUP [CREATE key groupname id-or-$] [SETID key id-or-$] [DESTROY key groupname] [DELCONSUMER key groupname consumername]
Create, destroy, and manage consumer groups.

* XINFO [CONSUMERS key groupname] [GROUPS key] [STREAM key] [HELP]
Get information on streams and consumer groups

* XLEN key
Return the number of entires in a stream

* XPENDING key group [start end count] [consumer]
Return information and entries from a stream consumer group pending entries list, that are messages fetched but never acknowledged.

* XRANGE key start end [COUNT count]
Return a range of elements in a stream, with IDs matching the specified IDs interval

* XREAD [COUNT count] [BLOCK milliseconds] STREAMS key [key ...] ID [ID ...]
Return never seen elements in multiple streams, with IDs greater than the ones reported by the caller for each stream. Can block.

* XREADGROUP GROUP group consumer [COUNT count] [BLOCK milliseconds] STREAMS key [key ...] ID [ID ...]
Return new entries from a stream using a consumer group, or access the history of the pending entries for a given consumer. Can block.

* XREVRANGE key end start [COUNT count]
Return a range of elements in a stream, with IDs matching the specified IDs interval, in reverse order (from greater to smaller IDs) compared to XRANGE

* XTRIM key MAXLEN [~] count
Trims the stream to (approximately if '~' is passed) a certain size
     * @param redisCmdParam
     * @return
     *
     * 接收前端界面，产生客户化命令
     */
    @RequestMapping(value = "/execCustRedisStreaming", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult execCustStreamingCmds(@Validated @RequestBody RedisCmdParam redisCmdParam) {
        return null;
    }
    @RequestMapping(value = "/execDefaultRedisStreaming", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult execDefaultStreamingCmds(@Validated @RequestBody RedisCmdParam redisCmdParam) {
        return null;
    }
}
