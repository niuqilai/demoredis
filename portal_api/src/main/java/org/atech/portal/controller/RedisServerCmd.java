package org.atech.portal.controller;

import org.atech.facade.bo.RedisCmdParam;
import org.atech.facade.common.CommonResult;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class RedisServerCmd {


    private RedisTemplate<String, Object> redisTemplate;

    /*
     BGREWRITEAOF
     异步重写追加文件命令
     BGSAVE
     异步保存数据集到磁盘上
     CLIENT KILL [ip:port] [ID client-id] [TYPE normal|slave|pubsub] [ADDR ip:port] [SKIPME yes/no]
     关闭客户端连接
     CLIENT LIST
     获得客户端连接列表
     CLIENT GETNAME
     获得当前连接名称
     CLIENT ID
     Returns the client ID for the current connection
     CLIENT PAUSE timeout
     暂停处理客户端命令
     CLIENT REPLY ON|OFF|SKIP
     Instruct the server whether to reply to commands
     CLIENT SETNAME connection-name
     设置当前连接的名字
     CLIENT UNBLOCK client-id [TIMEOUT|ERROR]
     Unblock a client blocked in a blocking command from a different connection
     COMMAND
     Get array of Redis command details
     COMMAND COUNT
     Get total number of Redis commands
     COMMAND GETKEYS
     Extract keys given a full Redis command
     COMMAND INFO command-name [command-name ...]
     Get array of specific Redis command details
     CONFIG GET parameter
     获取配置参数的值
     CONFIG REWRITE
     从写内存中的配置文件
     CONFIG SET parameter value
     设置配置文件
     CONFIG RESETSTAT
     复位再分配使用info命令报告的统计
     DBSIZE
     返回当前数据库里面的keys数量
     DEBUG OBJECT key
     获取一个key的debug信息
     DEBUG SEGFAULT
     使服务器崩溃命令
     FLUSHALL
     清空所有数据库命令
     FLUSHDB
     清空当前的数据库命令
     INFO [section]
     获得服务器的详细信息
     LASTSAVE
     获得最后一次同步磁盘的时间
     MEMORY DOCTOR
     Outputs memory problems report
     MEMORY HELP
     Show helpful text about the different subcommands
     MEMORY-MALLOC-STATS
     Show allocator internal stats
     MEMORY-PURGE
     Ask the allocator to release memory
     MEMORY-STATS
     Show memory usage details
     MEMORY-USAGE key [SAMPLES count]
     Estimate the memory usage of a key
     MONITOR
     实时监控服务器
     REPLICAOF host port
     Make the server a replica of another instance, or promote it as master.
     ROLE
     Return the role of the instance in the context of replication
     SAVE
     同步数据到磁盘上
     SHUTDOWN [NOSAVE] [SAVE]
     关闭服务
     SLAVEOF host port
     指定当前服务器的主服务器
     SLOWLOG subcommand [argument]
     管理再分配的慢查询日志
     SYNC
     用于复制的内部命令
     TIME
     返回当前服务器时间
     *
     * @param redisCmdParam
     * @return
     *
     * 接收前端界面，产生客户化命令
     */
    @RequestMapping(value = "/execCustRedisServer", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult execCustServerCmds(@Validated @RequestBody RedisCmdParam redisCmdParam) {
        return null;
    }
    @RequestMapping(value = "/execDefaultRedisServer", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult execDefaultServerCmds(@Validated @RequestBody RedisCmdParam redisCmdParam) {
        return null;
    }
}
