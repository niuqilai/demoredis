package org.atech.portal.controller;

import org.atech.facade.bo.RedisCmdParam;
import org.atech.facade.common.CommonResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class RedisSortedSetsCmd {

    /*
     *
     ZADD key [NX|XX] [CH] [INCR] score member [score member ...]                添加到有序set的一个或多个成员，或更新的分数，如果它已经存在
     ZCARD key                                                                   获取一个排序的集合中的成员数量
     ZCOUNT key min max                                                          返回分数范围内的成员数量
     ZINCRBY key increment member                                                增量的一名成员在排序设置的评分
     ZINTERSTORE destination numkeys key [key ...] [WEIGHTS weight [weight ...]] [AGGREGATE SUM|MIN|MAX]  相交多个排序集，导致排序的设置存储在一个新的关键
     ZLEXCOUNT key min max                                                        返回成员之间的成员数量
     ZPOPMAX key [count]                                                          Remove and return members with the highest scores in a sorted set
     ZPOPMIN key [count]                                                          Remove and return members with the lowest scores in a sorted set
     ZRANGE key start stop [WITHSCORES]                                          根据指定的index返回，返回sorted set的成员列表
     ZRANGEBYLEX key min max [LIMIT offset count]                                返回指定成员区间内的成员，按字典正序排列, 分数必须相同。
     ZREVRANGEBYLEX key max min [LIMIT offset count]                             返回指定成员区间内的成员，按字典倒序排列, 分数必须相同
     ZRANGEBYSCORE key min max [WITHSCORES] [LIMIT offset count]                 返回有序集合中指定分数区间内的成员，分数由低到高排序。
     ZRANK key member                                                            确定在排序集合成员的索引
     ZREM key member [member ...]                                                从排序的集合中删除一个或多个成员
     ZREMRANGEBYLEX key min max                                                  删除名称按字典由低到高排序成员之间所有成员。
     ZREMRANGEBYRANK key start stop                                              在排序设置的所有成员在给定的索引中删除
     ZREMRANGEBYSCORE key min max                                                删除一个排序的设置在给定的分数所有成员
     ZREVRANGE key start stop [WITHSCORES]                                       在排序的设置返回的成员范围，通过索引，下令从分数高到低
     ZREVRANGEBYSCORE key max min [WITHSCORES] [LIMIT offset count]              返回有序集合中指定分数区间内的成员，分数由高到低排序。
     ZREVRANK key member                                                         确定指数在排序集的成员，下令从分数高到低
     ZSCORE key member                                                           获取成员在排序设置相关的比分
     ZUNIONSTORE destination numkeys key [key ...] [WEIGHTS weight [weight ...]] [AGGREGATE SUM|MIN|MAX]  添加多个排序集和导致排序的设置存储在一个新的关键
     ZSCAN key cursor [MATCH pattern] [COUNT count]                              迭代sorted sets里面的元素
     * @param redisCmdParam
     * @return
     */
    @RequestMapping(value = "/execCustRedisSortedSet", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult execCustRedisSortedSetCmds(@Validated @RequestBody RedisCmdParam redisCmdParam) {
        return null;
    }
    @RequestMapping(value = "/execDefaultRedisSortedSet", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult execDefaultRedisSortedSetCmds(@Validated @RequestBody RedisCmdParam redisCmdParam) {
        return null;
    }


}
