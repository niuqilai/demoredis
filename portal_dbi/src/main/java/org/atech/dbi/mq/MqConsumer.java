package org.atech.dbi.mq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RocketMQMessageListener(topic = "${rocketmq.producer.topic}", consumerGroup = "${rocketmq.producer.group}")
public class MqConsumer implements RocketMQListener<String> {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(MqConsumer.class);

    @Override
    public void onMessage(String msg) {
        log.info("收到消息:" + msg);
    }
}

