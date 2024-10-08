package com.nmnd.d_book_backend.mapper;

import com.nmnd.d_book_backend.dto.request.BookCreationRequest;
import com.nmnd.d_book_backend.dto.request.ReceiptRequest;
import com.nmnd.d_book_backend.dto.response.BookResponse;
import com.nmnd.d_book_backend.dto.response.ReceiptResponse;
import com.nmnd.d_book_backend.entity.Book;
import com.nmnd.d_book_backend.entity.Receipt;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ReceiptDetailsMapper.class})
public interface ReceiptMapper {
    @Mapping(target = "paymentMethod", ignore = true)
    @Mapping(target = "user", ignore = true)
//    @Mapping(target = "voucher", ignore = true)
    @Mapping(source = "detailsRequests", target = "receiptDetails")
    Receipt toReceipt(ReceiptRequest request);

    @Mapping(source = "paymentMethod.name", target = "paymentMethodName")
    @Mapping(source = "user.fullName", target = "userName")
//    @Mapping(source = "voucher.code", target = "voucherCode")
    @Mapping(source = "receiptDetails", target = "detailsResponses")
    ReceiptResponse toReceiptResponse(Receipt receipt);
}
