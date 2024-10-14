package com.example.example.DTO;

import com.example.example.Entity.Member;
import com.example.example.Entity.Post;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class MemberDTO {
    private String name;
    private Long pwd;
    private String email;

    public Member toEntity()
    {
        // id는 자동생성되므로 값을 넣을 필요가 없다
        return new Member(null,pwd,email,name,new ArrayList<>());
    }
}
