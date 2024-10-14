package com.example.example.DTO;

import com.example.example.Entity.Member;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class MemberResponse {
    private Long idx;
    private Long pwd;
    private String name;
    private String email;
    private List<PostResponse> posts;

    public MemberResponse(Member member) {
        this.idx = member.getIdx();
        this.pwd = member.getPwd();
        this.name = member.getName();
        this.email = member.getEmail();
        this.posts =  member.getPosts().stream().map(PostResponse::new).toList();
    }
}
