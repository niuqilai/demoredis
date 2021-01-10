package org.atech.portal.controller;

import org.atech.facade.bo.RedisCmdParam;
import org.atech.facade.common.CommonResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class RedisGeoCmd {


    /*
     * GEOADD key longitude latitude member [longitude latitude member ...]
     * 添加一个或多个地理空间位置到sorted set
     * GEOHASH key member [member ...]
     * 返回一个标准的地理空间的Geohash字符串
     * GEOPOS key member [member ...]
     * 返回地理空间的经纬度
     * GEODIST key member1 member2 [unit]
     * 返回两个地理空间之间的距离
     * GEORADIUS key longitude latitude radius m|km|ft|mi [WITHCOORD] [WITHDIST] [WITHHASH] [COUNT count]
     * 查询指定半径内所有的地理空间元素的集合。
     * GEORADIUSBYMEMBER key member radius m|km|ft|mi [WITHCOORD] [WITHDIST] [WITHHASH] [COUNT count]
     * 查询指定半径内匹配到的最大距离的一个地理空间元素。
     */

    @RequestMapping(value = "/execCustRedisGeo", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult execCustGeoCmds(@Validated @RequestBody RedisCmdParam redisCmdParam) {
        //
        return null;
    }
    @RequestMapping(value = "/execDefaultRedisGeo", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult execDefaultGeoCmds(@Validated @RequestBody RedisCmdParam redisCmdParam) {

        return null;
    }
}
