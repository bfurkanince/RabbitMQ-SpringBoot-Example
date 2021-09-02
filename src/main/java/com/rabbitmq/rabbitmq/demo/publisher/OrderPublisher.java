package com.rabbitmq.rabbitmq.demo.publisher;

import com.rabbitmq.rabbitmq.demo.config.MessagingConfig;
import com.rabbitmq.rabbitmq.demo.dto.Order;
import com.rabbitmq.rabbitmq.demo.dto.OrderStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderPublisher {

    private static final String SUCESS_MESSAGE = "Success!";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/{restaurantName}")
    public String order(@RequestBody Order order , @PathVariable String restaurantName){
        order.setOrderId(UUID.randomUUID().toString());
        OrderStatus orderStatus = new OrderStatus(order , "PROCESS","order placed succesfully in " + restaurantName);
        rabbitTemplate.convertAndSend(MessagingConfig.EXCHANGE , MessagingConfig.ROUTING_KEY , orderStatus );
        return SUCESS_MESSAGE;
    }

}
