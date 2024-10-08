package com.nmnd.d_book_backend.service;

import com.nmnd.d_book_backend.dto.request.BookCreationRequest;
import com.nmnd.d_book_backend.dto.request.UserCreationRequest;
import com.nmnd.d_book_backend.dto.response.BookResponse;
import com.nmnd.d_book_backend.dto.response.UserResponse;
import com.nmnd.d_book_backend.entity.*;
import com.nmnd.d_book_backend.mapper.PublisherMapper;
import com.nmnd.d_book_backend.mapper.UserMapper;
import com.nmnd.d_book_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserMapper userMapper;

    public UserResponse createUser(UserCreationRequest request) {

        User user = userMapper.toUser(request);

        user.setCreatedTime(LocalDateTime.now());
        user.setUpdatedTime(LocalDateTime.now());

        user = userRepo.save(user);

        return userMapper.toUserResponse(user);
    }

    public List<UserResponse> getAllUsers() {
        var users = userRepo.findAll();

        return users.stream().map(userMapper::toUserResponse).toList();
    }

    public UserResponse getUser(String id) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return userMapper.toUserResponse(user);
    }

    public void deleteUser(String id) {
        userRepo.deleteById(id);
    }
}
