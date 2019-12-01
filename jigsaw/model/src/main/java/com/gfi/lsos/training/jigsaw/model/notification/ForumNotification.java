package com.gfi.lsos.training.jigsaw.model.notification;

import lombok.*;

@Value
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ForumNotification {

    private String forumName;

    private ActionType type;

    public static ForumNotification postAdded(String forumName){
        return create(forumName, ActionType.POST_ADDED);
    }

    public static ForumNotification postUpdated(String forumName){
        return create(forumName, ActionType.POST_UPDATED);
    }

    public static ForumNotification postRemoved(String forumName){
        return create(forumName, ActionType.POST_REMOVED);
    }

    private static ForumNotification create(String forumName, ActionType postRemoved) {
        return new ForumNotification(forumName, postRemoved);
    }

}
