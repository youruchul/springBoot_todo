package com.todo.dev.controller;

import com.todo.dev.domain.request.LoginRequest;
import com.todo.dev.domain.request.SignUpRequest;
import com.todo.dev.domain.response.MemberResponse;
import com.todo.dev.security.SecurityService;
import com.todo.dev.security.TokenRequired;
import com.todo.dev.service.MembersService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor // NonNull
@RequestMapping("/members")
public class MembersController {
    private  final MembersService membersService;
    private final SecurityService securityService;

    @PostMapping("/login")
    public MemberResponse login(@RequestBody LoginRequest loginRequest){
        return membersService.loginService(loginRequest);
    }

    @PostMapping("/signup")
    public MemberResponse signUp(@RequestBody SignUpRequest signUpRequest){
        return membersService.signUpService(signUpRequest);
    }

    @GetMapping("/check")
    @TokenRequired
    public MemberResponse tokenToken(){
        String token = securityService.getToken();
        return new MemberResponse(token, securityService.parseToken(token));
    }
}
