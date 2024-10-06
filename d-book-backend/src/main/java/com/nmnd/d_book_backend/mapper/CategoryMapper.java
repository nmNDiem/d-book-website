package com.nmnd.d_book_backend.mapper;

import com.nmnd.d_book_backend.dto.request.CategoryRequest;
import com.nmnd.d_book_backend.dto.response.CategoryResponse;
import com.nmnd.d_book_backend.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toCategory(CategoryRequest request);
    CategoryResponse toCategoryResponse(Category category);
}
