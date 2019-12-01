package com.gfi.lsos.training.jigsaw.model;

import static java.util.Objects.requireNonNull;

import java.util.List;

import com.gfi.lsos.training.jigsaw.model.notification.ForumNotification;
import com.gfi.lsos.training.jigsaw.model.notification.NotificationSender;
import com.gfi.lsos.training.jigsaw.model.stereotype.OutputPort;
import com.gfi.lsos.training.jigsaw.model.repository.ForumDao;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@OutputPort
class PostModelService implements PostService {

    private final ForumDao forumRepository;

    private final NotificationSender notificationSender;

    @Override
    public void create(String forumName, Post post) {
        Forum forum = forumRepository.findForumByName(forumName);
        forum.addPost(post);
        notificationSender.sendNotification(ForumNotification.postAdded(forumName));
    }

    @Override
    public List<Post> findAll(String forum) {
        return forumRepository
                .findForumByName(forum)
                .getPosts();
    }

    @Override
    public void remove(String forumName, Long postId) {
        Forum forum = forumRepository.findForumByName(forumName);
        forum.remove(postId);
        notificationSender.sendNotification(ForumNotification.postRemoved(forumName));
    }

    @Override
    public void update(String forumName, Post post) {
        Forum forum = forumRepository.findForumByName(requireNonNull(forumName));
        forum.updatePost(post);
        notificationSender.sendNotification(ForumNotification.postUpdated(forumName));
    }

}
