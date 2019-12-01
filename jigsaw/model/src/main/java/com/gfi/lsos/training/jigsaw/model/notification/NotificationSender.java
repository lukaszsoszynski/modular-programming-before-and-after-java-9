package com.gfi.lsos.training.jigsaw.model.notification;

import com.gfi.lsos.training.jigsaw.model.stereotype.InputPort;

@InputPort
public interface NotificationSender {

    void sendNotification(ForumNotification notification);
}
