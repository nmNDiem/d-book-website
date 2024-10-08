package com.nmnd.d_book_backend.dto.response;

import com.nmnd.d_book_backend.entity.PaymentMethod;
import com.nmnd.d_book_backend.entity.ReceiptDetails;
import com.nmnd.d_book_backend.entity.User;
import com.nmnd.d_book_backend.entity.Voucher;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReceiptResponse {
    int id;
    BigDecimal totalPrice;
    LocalDateTime createdTime;
    LocalDateTime paymentTime;
    String status;
    String customerName;
    String customerPhone;
    String customerEmail;
    String customerAddress;

    String paymentMethodName;
    String userName;
//    String voucherCode;

    List<ReceiptDetailsResponse> detailsResponses;
}
