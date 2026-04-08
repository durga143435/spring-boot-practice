package org.example.controllers;

import com.rabbitmq.client.Channel;
import org.example.configs.RabbitMqConfig;
import org.example.dtos.ConsumedMsgDto;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class ConsumeMsg {

    @RabbitListener(queues = RabbitMqConfig.PICKING_QUEUE)
    public void pickingQueueConsume(ConsumedMsgDto msg, Message message, Channel channel) throws IOException {


        try{
              System.out.println(msg);
              Map<String, Object> headers =  message.getMessageProperties().getHeaders();
              headers.keySet().forEach(key -> System.out.println("key: " +key + "        value: "+headers.get(key)));

                System.out.println(10/0);
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);


        }catch(Exception e){
            // NACK → requeue = false (send to DLQ if configured)
            channel.basicNack(message.getMessageProperties().getDeliveryTag(),false, true);
//            channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
        }

    }

    @RabbitListener(queues = RabbitMqConfig.RECEIVING_QUEUE1)
    public void receiveQueueOne(ConsumedMsgDto msg, Message message, Channel channel) throws IOException {
        try{
            System.out.println(msg);
            Map<String, Object> headers =  message.getMessageProperties().getHeaders();
            headers.keySet().forEach(key -> System.out.println("key: " +key + "        value: "+headers.get(key)));
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);

        }catch(Exception e){
            // NACK → requeue = false (send to DLQ if configured)
            channel.basicNack(message.getMessageProperties().getDeliveryTag(),false, false);
        }

    }

    @RabbitListener(queues = RabbitMqConfig.RECEIVING_QUEUE2)
    public void receiveQueueTwo(ConsumedMsgDto msg, Message message, Channel channel) throws IOException {
        try {
            System.out.println(msg);
            System.out.println(10/0);
            Map<String, Object> headers = message.getMessageProperties().getHeaders();
            System.out.println("proceess complete");
            headers.keySet().forEach(key -> System.out.println("key: " + key + "        value: " + headers.get(key)));
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);

        } catch (Exception e) {
            // NACK → requeue = false (send to DLQ if configured)
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
        }
    }

        @RabbitListener(queues = RabbitMqConfig.RECEIVING_QUEUE3)
        public void receiveQueueThree(ConsumedMsgDto msg, Message message, Channel channel) throws IOException {
            try{
                System.out.println(msg);
                Map<String, Object> headers =  message.getMessageProperties().getHeaders();
                headers.keySet().forEach(key -> System.out.println("key: " +key + "        value: "+headers.get(key)));
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);

            }catch(Exception e){
                // NACK → requeue = false (send to DLQ if configured)
                channel.basicNack(message.getMessageProperties().getDeliveryTag(),false, false);
            }

    }
}
