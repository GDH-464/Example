package com.example.example.DTO;

import com.example.example.Entity.Member;
import com.example.example.Entity.Post;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PostDTO {
    private String title;
    private String content;

    public Post posttoEntity(Member member)
    {
        return new Post(null,title,content,member);
    }
}
