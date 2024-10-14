package com.example.example.DTO;

import com.example.example.Entity.Post;
import lombok.*;

@Getter
@ToString
public class PostResponse {
    private Long idx;
    private String title;
    private String content;
    private String memberName;


    public PostResponse(Post post) {
        this.idx = post.getIdx();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.memberName = post.getMember().getName();
    }
}
