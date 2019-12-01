package com.gfi.lsos.training.jigsaw.soapprimaryadapter.converter;

import com.gfi.lsos.training.jigsaw.model.Post;
import com.gfi.lsos.training.jigsaw.soap.PersistentPostType;
import com.gfi.lsos.training.jigsaw.soap.PostType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
class PostTypeToPostConverter implements Converter<PostType, Post>{

    @Override
    public Post convert(PostType postType) {
        Long id = null;
        if(postType instanceof PersistentPostType){
            PersistentPostType persistentPostType = (PersistentPostType) postType;
            id = persistentPostType.getPostId();
        }
        return new Post(id, postType.getTitle(), postType.getContent());
    }
}
