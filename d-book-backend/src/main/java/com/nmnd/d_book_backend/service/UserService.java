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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ImageService imageService;

    public UserResponse createUser(UserCreationRequest request) throws IOException {
        MultipartFile file = request.getImage();

        User user = userMapper.toUser(request);
        if (file != null && !file.isEmpty()) {
            String imageUrl = imageService.uploadImage(file);     // up len cloudinary, tra ve url
            user.setImage(imageUrl);
        }

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
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
