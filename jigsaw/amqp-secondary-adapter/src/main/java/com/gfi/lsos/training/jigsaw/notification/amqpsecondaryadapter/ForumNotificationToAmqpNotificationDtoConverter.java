package com.gfi.lsos.training.jigsaw.notification.amqpsecondaryadapter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.gfi.lsos.training.jigsaw.model.notification.ForumNotification;
import com.gfi.lsos.training.jigsaw.notification.amqp.AmqpForumNotificationDto;

@Component
class ForumNotificationToAmqpNotificationDtoConverter implements Converter<ForumNotification, AmqpForumNotificationDto>{

    @Override
    public AmqpForumNotificationDto convert(ForumNotification forumNotification) {
        return new AmqpForumNotificationDto(forumNotification.getForumName());
    }
}
