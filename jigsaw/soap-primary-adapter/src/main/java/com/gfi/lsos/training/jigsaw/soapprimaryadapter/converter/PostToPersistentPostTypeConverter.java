package com.gfi.lsos.training.jigsaw.soapprimaryadapter.converter;

import com.gfi.lsos.training.jigsaw.model.Post;
import com.gfi.lsos.training.jigsaw.soap.PersistentPostType;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class PostToPersistentPostTypeConverter implements Converter<Post, PersistentPostType>{

    @Override
    public PersistentPostType convert(Post post) {
        PersistentPostType persistentPostType = new PersistentPostType();
        persistentPostType.setContent(post.getContent());
        persistentPostType.setForumName(post.getForumName());
        persistentPostType.setTitle(post.getTitle());
        persistentPostType.setPostId(post.getId());
        return persistentPostType;
    }
}
