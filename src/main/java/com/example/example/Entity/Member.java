package com.example.example.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

//  필드에 null값이 오지 않는다 (NOT Null)
    @Column(nullable = false)
    private Long pwd;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

//    1:N 관계설정
//    post 엔티티에 있는 member 필드 연결
    @OneToMany(mappedBy = "member")
    private List<Post> posts;
}
