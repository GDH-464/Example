package com.example.example.Controller;

import com.example.example.DTO.MemberDTO;
import com.example.example.DTO.MemberResponse;
import com.example.example.DTO.PostResponse;
import com.example.example.Entity.Member;
import com.example.example.Repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 컨트롤러를 rest api로 만들어준다.
@Log4j2
@RestController
public class MemberController {
//        DI (의존성 주입) dependency Injection
    private final MemberRepository memberRepository;

    @Autowired
    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @GetMapping("/")
    public String helloworld(){
        return "hello world";
    }

    @GetMapping("/user")
    public List<MemberResponse> getUser(){
        List<Member> members = memberRepository.findAll();
        return members.stream().map(MemberResponse::new).toList();
    }
    @PostMapping("/user")
    public MemberResponse createMember(@RequestBody MemberDTO memberDTO) {

        Member member = memberDTO.toEntity();
        memberRepository.save(member);
        log.error(member.toString());
        return new MemberResponse(member);
    }
}
