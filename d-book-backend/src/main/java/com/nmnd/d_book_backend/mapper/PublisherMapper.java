package com.nmnd.d_book_backend.mapper;

import com.nmnd.d_book_backend.dto.request.PublisherRequest;
import com.nmnd.d_book_backend.dto.response.PublisherResponse;
import com.nmnd.d_book_backend.entity.Publisher;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PublisherMapper {
    Publisher toPublisher(PublisherRequest request);
    PublisherResponse toPublisherResponse(Publisher publisher);
}
