package com.nmnd.d_book_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class GoodsReceiptDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int quantity;
    BigDecimal unitPrice;

    @ManyToOne
    @JoinColumn(name = "book_id")
    Book bookId;

    @ManyToOne
    @JoinColumn(name = "goods_receipt_id")
    GoodsReceipt goodsReceiptId;
}
