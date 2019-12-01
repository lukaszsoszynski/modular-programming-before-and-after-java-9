package com.gfi.lsos.training.jigsaw.restprimaryport;

import com.gfi.lsos.training.jigsaw.model.Post;
import com.gfi.lsos.training.jigsaw.model.PostService;
import com.gfi.lsos.training.jigsaw.rest.RestPostService;
import com.gfi.lsos.training.jigsaw.rest.dto.PostDto;
import lombok.Setter;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Service
//@RequiredArgsConstructor
//constructor dependencies does not works
//Caused by: org.springframework.aop.framework.AopConfigException: Unexpected AOP exception; nested exception is org.springframework.aop.framework.AopConfigException: Unable to instantiate proxy using Objenesis, and regular proxy instantiation via default constructor fails as well; nested exception is java.lang.NoSuchMethodException: com.gfi.lsos.training.jigsaw.restprimaryport.PostPrimaryAdapter$$EnhancerBySpringCGLIB$$bf85bcd.<init>()
//probably problem related with declarative transaction management
public class PostPrimaryAdapter implements RestPostService{

    @Setter(onMethod = @__(@Autowired))
    private PostService postService;

    @Setter(onMethod = @__(@Autowired))
    private ConversionService conversionService;

    @Transactional
    public void create(PostDto postDto) {
        Post post = conversionService.convert(postDto, Post.class);
        postService.create(postDto.getForumName(), post);
    }

    @Transactional(readOnly = true)
    public List<PostDto> findAll(String forum) {
        return postService.findAll(forum)
                .stream()
                .map(post -> conversionService.convert(post, PostDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public void remove(String forumName, Long postId) {
        postService.remove(forumName, postId);
    }

    @Transactional
    public void update(PostDto postDto) {
        Post post = conversionService.convert(postDto, Post.class);
        postService.update(postDto.getForumName(), post);
    }
}
