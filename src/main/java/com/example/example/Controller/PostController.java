package com.example.example.Controller;

import com.example.example.DTO.PostDTO;
import com.example.example.DTO.PostResponse;
import com.example.example.Entity.Member;
import com.example.example.Entity.Post;
import com.example.example.Repository.MemberRepository;
import com.example.example.Repository.PostRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@RestController
public class PostController {

    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    @Autowired
    public PostController(PostRepository postRepository,MemberRepository memberRepository) {
        this.postRepository = postRepository;
        this.memberRepository = memberRepository;
    }

    @GetMapping("/post")
    public List<PostResponse> getPosts(){
        List<Post> posts=postRepository.findAll();
        return posts.stream().map(PostResponse::new).toList();
    }

    //param : url뒤에 붙는 query parameter
    @PostMapping("/post")
    public PostResponse addpost(@RequestParam(value = "idx") Long idx, @RequestBody PostDTO post) {
        //Optional : 값이 존재하지 않을때는 null을 반환
        Member member= memberRepository.findById(idx).orElse(null);
        // PostDTO에서 entity로 변환
        Post posts = post.posttoEntity(member);
//        변환한 엔티티를 데이터베이스에 자장하고 값 출력
        postRepository.save(posts);
//        저장된 값을 PostResponse로 변환
        PostResponse postResponse = new PostResponse(posts);
//       postResponse 내용 터미널에 출력
        log.error(postResponse.toString());
//        postResponse 반환
        return postResponse;
    }
}
