package com.gfi.lsos.training.jigsaw.rest;

import java.util.List;

import com.gfi.lsos.training.jigsaw.rest.dto.PostDto;

public interface RestPostService {

    List<PostDto> findAll(String forum);

    void create(PostDto postDto);

    void remove(String forum, Long postId);

    void update(PostDto postDto);
}
