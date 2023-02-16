package com.rabbitmq.producer.amqpproducer.runner;

import ch.qos.logback.core.testUtil.RandomUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.producer.amqpproducer.model.Order;
import com.rabbitmq.producer.amqpproducer.sender.OrderQueueSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

@Component
public class QueueRunner implements CommandLineRunner {

    @Autowired
    private OrderQueueSender sender;

    @Override
    public void run(String... args) throws Exception {

        System.out.printf("-- run runnner ---");

        var mapper = new ObjectMapper();

        var order = Order.builder()
                        .orderDate(Date.from(Instant.now()))
                                .orderId(RandomUtil.getPositiveInt())
                .serviceType("paid")
                                        .customerName("John Doe")
                                                .status("ACTIVE")
                                                        .build();

        var jsonOrder = mapper.writeValueAsString(order);

        sender.send(jsonOrder);

    }


}
