package com.nmnd.d_book_backend.controller;

import com.nmnd.d_book_backend.dto.request.AuthenticationRequest;
import com.nmnd.d_book_backend.dto.response.AuthenticationResponse;
import com.nmnd.d_book_backend.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    @Autowired
    private AuthenticationService authService;

    @PostMapping("/login")
    boolean authenticate(@RequestBody AuthenticationRequest request){
        return authService.authenticate(request);
    }
}
