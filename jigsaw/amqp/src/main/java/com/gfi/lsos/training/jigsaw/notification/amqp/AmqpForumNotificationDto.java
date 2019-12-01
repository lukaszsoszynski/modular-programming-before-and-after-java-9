package com.gfi.lsos.training.jigsaw.notification.amqp;

//import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Value;

@Value
public class AmqpForumNotificationDto {

//    @JsonProperty("forum_name")
    private String forumName;
}
