package org.example.controllers;

import com.rabbitmq.client.Channel;
import org.example.dtos.ConsumedMsgDto;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ConsumingFromDifferentExchanges {

    @RabbitListener(queues = "default.Q1")
    public void counsumeDefaultExchange(ConsumedMsgDto msg, Message message, Channel channel) throws IOException {
        try{
            System.out.println(msg);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
        }
    }

    @RabbitListener(queues = "test.queue")
    public void consumeDirectExchange(ConsumedMsgDto msg, Message message, Channel channel) throws IOException {
        try{
            System.out.println(msg);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        }catch (Exception e){
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
        }

    }
}
