package com.gfi.lsos.training.jigsaw.restprimaryport;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.gfi.lsos.training.jigsaw.model.Post;
import com.gfi.lsos.training.jigsaw.rest.dto.PostDto;

@Component
public class PostDtoConverter implements Converter<Post, PostDto> {

    @Override
    public PostDto convert(Post post) {
        return new PostDto(post.getId(), post.getForumName(), post.getTitle(), post.getContent());
    }
}
