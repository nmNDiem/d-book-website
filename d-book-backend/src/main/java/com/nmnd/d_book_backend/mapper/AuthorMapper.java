package com.nmnd.d_book_backend.mapper;

import com.nmnd.d_book_backend.dto.request.AuthorRequest;
import com.nmnd.d_book_backend.dto.response.AuthorResponse;
import com.nmnd.d_book_backend.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    Author toAuthor(AuthorRequest request);
    void updateAuthor(@MappingTarget Author author, AuthorRequest request);
    AuthorResponse toAuthorResponse(Author author);
}
