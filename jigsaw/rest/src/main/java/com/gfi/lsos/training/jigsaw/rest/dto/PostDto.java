package com.gfi.lsos.training.jigsaw.rest.dto;

import lombok.Value;
import lombok.experimental.Wither;

@Value
public class PostDto {

    @Wither
    private Long postId;

    @Wither
    private String forumName;

    private String title;

    private String content;
}
