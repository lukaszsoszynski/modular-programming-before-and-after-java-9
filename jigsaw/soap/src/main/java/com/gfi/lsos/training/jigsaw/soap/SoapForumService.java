package com.gfi.lsos.training.jigsaw.soap;

public interface SoapForumService {

    GetAllPostResponse getAllPost(GetAllPostRequest getAllPostRequest);

    void createPost(PostType createPostRequest);

    void removePost(RemovePostRequest removePostRequest);

    void updatePost(PersistentPostType updatePostRequest);

}
