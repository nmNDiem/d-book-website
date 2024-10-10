package com.nmnd.d_book_backend.service;

import com.nmnd.d_book_backend.dto.request.AuthenticationRequest;
import com.nmnd.d_book_backend.dto.request.CategoryRequest;
import com.nmnd.d_book_backend.dto.response.CategoryResponse;
import com.nmnd.d_book_backend.entity.Category;
import com.nmnd.d_book_backend.mapper.CategoryMapper;
import com.nmnd.d_book_backend.repository.CategoryRepository;
import com.nmnd.d_book_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationService {
    @Autowired
    private UserRepository userRepo;

    public boolean authenticate(AuthenticationRequest request) {
        var user = userRepo.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        return passwordEncoder.matches(request.getPassword(), user.getPassword());
    }
}
