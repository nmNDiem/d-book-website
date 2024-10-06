package com.nmnd.d_book_backend.mapper;

import com.nmnd.d_book_backend.dto.request.BookCreationRequest;
import com.nmnd.d_book_backend.dto.response.BookResponse;
import com.nmnd.d_book_backend.entity.Author;
import com.nmnd.d_book_backend.entity.Book;
import com.nmnd.d_book_backend.entity.Category;
import com.nmnd.d_book_backend.entity.Publisher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "author", ignore = true)
    @Mapping(target = "publisher", ignore = true)
    Book toBook(BookCreationRequest request);

    @Mapping(source = "category.name", target = "categoryName")
    @Mapping(source = "author.name", target = "authorName")
    @Mapping(source = "publisher.name", target = "publisherName")
    BookResponse toBookResponse(Book book);
}
