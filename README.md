
cd/enviroment

docker-compose up -d 

rabbitmq host: http://localhost:15672/

create queue:  order-queue

# RabbitMQ Communication Flow

This is a sequence diagram that shows the communication flow between a RabbitMQ consumer and a producer.

```mermaid
sequenceDiagram
    participant order-producer
    participant RabbitMQ
    participant order-consumer
    
    order-producer->>RabbitMQ: Publish message to queue
    RabbitMQ->>order-consumer: Deliver message from queue
    order-consumer->>RabbitMQ: Send acknowledgement
    RabbitMQ->>order-producer: Receive acknowledgement

