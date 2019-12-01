package com.gfi.lsos.training.jigsaw.soapprimaryadapter.converter;

import com.gfi.lsos.training.jigsaw.model.Post;
import com.gfi.lsos.training.jigsaw.soap.PostType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
class PostToPostTypeConverter implements Converter<Post, PostType> {

    @Override
    public PostType convert(Post post) {
        PostType postType = new PostType();
        postType.setContent(post.getContent());
        postType.setForumName(post.getForumName());
        postType.setTitle(post.getTitle());
        return postType;
    }
}
