package com.gradle.gradle.rabbitMQ;

import com.gradle.gradle.dto.in.DeleteEmployeeInDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQ {
    @RabbitListener(queues = "myQueue")
    private void rabbit(@Payload DeleteEmployeeInDTO deleteEmployeeInDTO){
        System.out.println("test");
    }
}
