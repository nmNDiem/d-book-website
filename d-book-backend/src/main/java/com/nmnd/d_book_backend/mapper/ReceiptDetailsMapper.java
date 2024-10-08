package com.nmnd.d_book_backend.mapper;

import com.nmnd.d_book_backend.dto.request.PublisherRequest;
import com.nmnd.d_book_backend.dto.request.ReceiptDetailsRequest;
import com.nmnd.d_book_backend.dto.response.PublisherResponse;
import com.nmnd.d_book_backend.dto.response.ReceiptDetailsResponse;
import com.nmnd.d_book_backend.entity.Publisher;
import com.nmnd.d_book_backend.entity.ReceiptDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReceiptDetailsMapper {
    @Mapping(target = "book", ignore = true)
    ReceiptDetails toReceiptDetails(ReceiptDetailsRequest request);

    @Mapping(source = "book.title", target = "bookTitle")
    @Mapping(source = "receipt.id", target = "receiptId")
    ReceiptDetailsResponse toReceiptDetailsResponse(ReceiptDetails receiptDetails);
}
