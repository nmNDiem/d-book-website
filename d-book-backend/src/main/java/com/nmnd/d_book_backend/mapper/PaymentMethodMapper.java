package com.nmnd.d_book_backend.mapper;

import com.nmnd.d_book_backend.dto.request.PaymentMethodRequest;
import com.nmnd.d_book_backend.dto.response.PaymentMethodResponse;
import com.nmnd.d_book_backend.entity.PaymentMethod;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PaymentMethodMapper {
    PaymentMethod toPaymentMethod(PaymentMethodRequest request);
    void updatePaymentMethod(@MappingTarget PaymentMethod paymentMethod, PaymentMethodRequest request);
    PaymentMethodResponse toPaymentMethodResponse(PaymentMethod paymentMethod);
}
