package com.nmnd.d_book_backend.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReceiptDetailsResponse {
    int id;
    String bookTitle;
    int quantity;
    BigDecimal unitPrice;
    int receiptId;
}
