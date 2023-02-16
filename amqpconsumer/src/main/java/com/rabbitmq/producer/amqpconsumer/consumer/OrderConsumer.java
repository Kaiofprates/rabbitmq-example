package com.rabbitmq.producer.amqpconsumer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.LoggerFactoryFriend;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

    Logger log = LoggerFactory.getLogger(OrderConsumer.class);

    @RabbitListener(queues = {"${queue.order.name}"})
    public void receive(@Payload String payload) {

        log.info("Order: " + payload);
    }

}
