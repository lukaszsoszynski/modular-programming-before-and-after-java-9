package com.gfi.lsos.training.jigsaw.notification.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.util.Assert;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Component
@Slf4j
public class AmqpNotificationSender {

    private static final String FORUM_EXCHANGE = "forum";
    private final RabbitTemplate rabbitTemplate;

    /*
    Queue e.q. hexagonal-architecture-forum-queue
     */
    public void sendNotification(AmqpForumNotificationDto forumNotification, String typeName){
        Assert.notNull(forumNotification, "Notification is required.");
        String routingKey = routingKeyForNotification(typeName, forumNotification);
        onTransactionSuccessfullyCommitted(() -> sendNotificationImmediate(forumNotification, routingKey));
    }

    private String routingKeyForNotification(String typeName, AmqpForumNotificationDto notification) {
        return String.format("forum.action.%s", typeName.toLowerCase().replace("_", "."));
    }

    private void sendNotificationImmediate(AmqpForumNotificationDto notification, String routingKey) {
        log.info("Send notification '{}' with routing key '{}'.", notification, routingKey);
        rabbitTemplate.convertAndSend(FORUM_EXCHANGE, routingKey, notification);
    }

    private void onTransactionSuccessfullyCommitted(Runnable runnableAfterTransactionCommitted) {
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
            @Override
            public void afterCommit() {
                runnableAfterTransactionCommitted.run();
            }
        });
    }
}
