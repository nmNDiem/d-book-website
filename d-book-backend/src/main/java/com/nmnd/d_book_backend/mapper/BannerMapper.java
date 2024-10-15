package com.nmnd.d_book_backend.mapper;

import com.nmnd.d_book_backend.dto.request.BannerRequest;
import com.nmnd.d_book_backend.dto.request.CategoryRequest;
import com.nmnd.d_book_backend.dto.response.BannerResponse;
import com.nmnd.d_book_backend.dto.response.CategoryResponse;
import com.nmnd.d_book_backend.entity.Banner;
import com.nmnd.d_book_backend.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BannerMapper {
    @Mapping(target = "image", ignore = true)
    Banner toBanner(BannerRequest request);
    BannerResponse toBannerResponse(Banner banner);
}
