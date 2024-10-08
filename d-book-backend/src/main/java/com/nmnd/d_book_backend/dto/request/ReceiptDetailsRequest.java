package com.nmnd.d_book_backend.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReceiptDetailsRequest {
    int bookId;
    int quantity;
    BigDecimal unitPrice;
}
