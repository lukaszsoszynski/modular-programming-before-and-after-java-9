package com.gfi.lsos.training.jigsaw.model;

import static java.util.Objects.requireNonNull;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString(exclude = "forum")
public class Post {

    public static final String POST_SEQUENCE_GENERATOR = "post_sequence_generator";

    private Long id;

    private String title;

    private String content;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.PACKAGE)
    private Forum forum;

    public Post(Long id, String title, String content){
        this.id = id;
        this.title = requireNonNull(title);
        this.content = requireNonNull(content);
    }

    public boolean hasId(Long postId){
        return id.equals(postId);
    }

    public void update(Post post) {
        this.title = requireNonNull(post.getTitle());
        this.content = requireNonNull(post.getContent());
    }

    public String getForumName(){
        return forum.getName();
    }
}
