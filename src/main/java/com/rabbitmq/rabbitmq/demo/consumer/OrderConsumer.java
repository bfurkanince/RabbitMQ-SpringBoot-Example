package com.rabbitmq.rabbitmq.demo.consumer;

import com.rabbitmq.rabbitmq.demo.config.MessagingConfig;
import com.rabbitmq.rabbitmq.demo.dto.OrderStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(OrderConsumer.class);

    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void consumeMessageFromQueue(OrderStatus orderStatus){
        LOG.info("Message received from queue : " + orderStatus.toString());
    }

}
