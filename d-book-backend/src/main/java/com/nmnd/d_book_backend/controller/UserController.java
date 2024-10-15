package com.nmnd.d_book_backend.controller;

import com.nmnd.d_book_backend.dto.request.BookCreationRequest;
import com.nmnd.d_book_backend.dto.request.UserCreationRequest;
import com.nmnd.d_book_backend.dto.response.BookResponse;
import com.nmnd.d_book_backend.dto.response.UserResponse;
import com.nmnd.d_book_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    UserResponse createUser(@ModelAttribute UserCreationRequest request) throws IOException {
        return userService.createUser(request);
    }

    @GetMapping
    List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    UserResponse getUser(@PathVariable String userId) {
        return userService.getUser(userId);
    }

    @DeleteMapping("/{userId}")
    void deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
    }
}
