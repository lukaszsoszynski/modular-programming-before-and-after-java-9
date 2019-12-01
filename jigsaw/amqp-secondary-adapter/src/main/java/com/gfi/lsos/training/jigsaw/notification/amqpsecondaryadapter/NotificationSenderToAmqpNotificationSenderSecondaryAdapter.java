package com.gfi.lsos.training.jigsaw.notification.amqpsecondaryadapter;

import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.gfi.lsos.training.jigsaw.model.notification.ForumNotification;
import com.gfi.lsos.training.jigsaw.model.notification.NotificationSender;
import com.gfi.lsos.training.jigsaw.notification.amqp.AmqpForumNotificationDto;
import com.gfi.lsos.training.jigsaw.notification.amqp.AmqpNotificationSender;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Component
@Slf4j
class NotificationSenderToAmqpNotificationSenderSecondaryAdapter implements NotificationSender {

    private final AmqpNotificationSender amqpNotificationSender;
    private final ConversionService conversionService;

    /*
    Queue e.q. hexagonal-architecture-forum-queue
     */
    @Override
    public void sendNotification(ForumNotification forumNotification){
        Assert.notNull(forumNotification, "Notification is required.");
        AmqpForumNotificationDto amqpForumNotificationDto = conversionService.convert(forumNotification, AmqpForumNotificationDto.class);
        amqpNotificationSender.sendNotification(amqpForumNotificationDto, forumNotification.getType().name());
    }
}
