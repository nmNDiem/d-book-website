package com.nmnd.d_book_backend.mapper;

import com.nmnd.d_book_backend.dto.request.AuthorRequest;
import com.nmnd.d_book_backend.dto.request.UserCreationRequest;
import com.nmnd.d_book_backend.dto.request.UserUpdateRequest;
import com.nmnd.d_book_backend.dto.response.AuthorResponse;
import com.nmnd.d_book_backend.dto.response.UserResponse;
import com.nmnd.d_book_backend.entity.Author;
import com.nmnd.d_book_backend.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "image", ignore = true)
    User toUser(UserCreationRequest request);

    @Mapping(target = "image", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);

    UserResponse toUserResponse(User user);
}
