package br.com.techchallenge.schedule_management.infrastructure.config.rabbitmq;

import org.springframework.amqp.core.*;
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
    public static final String HISTORY_QUEUE = "history_queue";
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
    public DirectExchange getHistoryExchange() {
        return new DirectExchange(HISTORY_EXCHANGE_NAME);
    }

    @Bean
    public Queue getHistoryQueue() {
        return new Queue(HISTORY_QUEUE, true);
    }

    @Bean
    public Binding getHistoryBinding(
            @Qualifier("getHistoryQueue")
            Queue historyQueue,
            @Qualifier("getHistoryExchange")
            DirectExchange historyExchange
    ) {
        return BindingBuilder
                .bind(historyQueue)
                .to(historyExchange)
                .with(HISTORY_ROUTING_KEY);
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
