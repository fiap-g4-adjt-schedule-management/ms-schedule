package br.com.techchallenge.schedule_management.infrastructure.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    public static final String NOTIFICATION_EXCHANGE_NAME = "notification_exchange";
    public static final String NOTIFICATION_QUEUE = "notification_queue";
    public static final String NOTIFICATION_ROUTING_KEY = "notification";

    public static final String HISTORY_EXCHANGE_NAME = "history_exchange";
    public static final String HISTORY_ROUTING_KEY = "history";

    @Bean
    public DirectExchange getNotificationExchange() {
        return new DirectExchange(NOTIFICATION_EXCHANGE_NAME);
    }

    @Bean
    public Queue getNotificationQueue() {
        return new Queue(NOTIFICATION_QUEUE, true);
    }

    @Bean
    public Binding getNotificationBinding(
            @Qualifier("getNotificationQueue")
            Queue notificationQueue,
            @Qualifier("getNotificationExchange")
            DirectExchange notificationExchange
    ) {
        return BindingBuilder
                .bind(notificationQueue)
                .to(notificationExchange)
                .with(NOTIFICATION_ROUTING_KEY);
    }

    @Bean
    public TopicExchange historyExchange() {
        return new TopicExchange(HISTORY_EXCHANGE_NAME, true, false);
    }

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate notificationRabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);

        rabbitTemplate.setMessageConverter(jsonMessageConverter());

        return rabbitTemplate;
    }

}
