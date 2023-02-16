package com.rabbitmq.producer.amqpproducer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Order {

    private int orderId;
    private String customerName;
    private String serviceType;
    private Date orderDate;
    private String status;
}
