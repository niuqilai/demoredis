package org.atech.portal.mq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MqProducer {
    Logger log = org.slf4j.LoggerFactory.getLogger(MqProducer.class);
//    @Autowired
//    private RocketMQTemplate rocketMQTemplate;
//    public void sendMsg(String topic, String msg)
//    {
//        log.info("发送报文：" + msg);
//        this.rocketMQTemplate.convertAndSend(topic, msg);
//    }
}
