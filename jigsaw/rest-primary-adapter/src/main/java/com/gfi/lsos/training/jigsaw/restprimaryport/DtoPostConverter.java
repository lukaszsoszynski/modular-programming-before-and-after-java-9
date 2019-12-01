package com.gfi.lsos.training.jigsaw.restprimaryport;

import com.gfi.lsos.training.jigsaw.model.Post;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.gfi.lsos.training.jigsaw.rest.dto.PostDto;

@Component
public class DtoPostConverter implements Converter<PostDto, Post> {

    @Override
    public Post convert(PostDto postDto) {
        return new Post(postDto.getPostId(), postDto.getTitle(), postDto.getContent());
    }
}
