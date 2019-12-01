package com.gfi.lsos.training.jigsaw.model;

import java.util.List;

public interface PostService {

    void create(String forumName, Post post);

    List<Post> findAll(String forum);

    void remove(String forumName, Long postId);

    void update(String forumName, Post post);
}
