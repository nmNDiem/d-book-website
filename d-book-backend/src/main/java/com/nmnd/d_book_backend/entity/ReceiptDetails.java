
package com.nmnd.d_book_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class ReceiptDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // cac chuoi random ngau nhien
    int id;
    int quantity;
    BigDecimal unitPrice;

    @ManyToOne
    @JoinColumn(name = "book_id")
    Book bookId;

    @ManyToOne
    @JoinColumn(name = "receipt_id")
    Receipt receiptId;
}
