package com.nmnd.d_book_backend.dto.request;

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
public class ReceiptRequest {
    BigDecimal totalPrice;
    String customerName;
    String customerPhone;
    String customerEmail;
    String customerAddress;

    int paymentMethodId;
    String userId;
//    int voucherId;

    List<ReceiptDetailsRequest> detailsRequests;
}
