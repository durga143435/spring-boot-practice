package org.example.configs;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    public static final String PICKING_QUEUE = "picking.queue";
    public static final String PICKING_EXCHANGE = "picking.direct.exchange";

    public static final String RECEIVING_EXCHANGE= "receiving.direct.exchange";
    public static final String RECEIVING_QUEUE1= "receive.direct.queue1";
    public static final String RECEIVING_QUEUE2= "receive.direct.queue2";
    public static final String RECEIVING_QUEUE3= "receive.direct.queue3";

    @Bean
    public MessageConverter jsonMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(MessageConverter messageConverter,
                                         ConnectionFactory connectionFactory){
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter);
        return template;
    }


}
