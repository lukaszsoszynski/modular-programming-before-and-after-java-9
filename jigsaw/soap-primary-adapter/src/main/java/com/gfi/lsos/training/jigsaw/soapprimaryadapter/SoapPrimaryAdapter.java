package com.gfi.lsos.training.jigsaw.soapprimaryadapter;

import com.gfi.lsos.training.jigsaw.model.Post;
import com.gfi.lsos.training.jigsaw.model.PostService;
import com.gfi.lsos.training.jigsaw.soap.*;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
//@RequiredArgsConstructor
//spring cannot create proxy when:
//- jigsaw module system is used
//- class is non public
//- class has no args constructor
//- probably problems are related with aop proxy responsible for transaction management
class SoapPrimaryAdapter implements SoapForumService {

    @Setter(onMethod = @__(@Autowired))
    private PostService postService;

    @Setter(onMethod = @__(@Autowired))
    private ConversionService conversionService;

    @Override
    @Transactional(readOnly = true)
    public GetAllPostResponse getAllPost(GetAllPostRequest request) {
        List<PersistentPostType> listOfPosts = findAllPost(request.getForumName());
        return createGetAllPostResponse(listOfPosts);
    }

    @Override
    @Transactional
    public void createPost(PostType postType) {
        postService.create(postType.getForumName(), conversionService.convert(postType, Post.class));
    }

    @Override
    @Transactional
    public void removePost(RemovePostRequest removePostRequest) {
        postService.remove(removePostRequest.getForumName(), removePostRequest.getPostId());
    }

    @Override
    @Transactional
    public void updatePost(PersistentPostType persistentPostType) {
        postService.update(persistentPostType.getForumName(), conversionService.convert(persistentPostType, Post.class));
    }

    private List<PersistentPostType> findAllPost(String forumName) {
        return postService
                .findAll(forumName)
                .stream()
                .map(post -> conversionService.convert(post, PersistentPostType.class))
                .collect(Collectors.toList());
    }

    private GetAllPostResponse createGetAllPostResponse(List<PersistentPostType> listOfPosts) {
        GetAllPostResponse response = new GetAllPostResponse();
        response
                .getPost()
                .addAll(listOfPosts);
        return response;
    }
}
