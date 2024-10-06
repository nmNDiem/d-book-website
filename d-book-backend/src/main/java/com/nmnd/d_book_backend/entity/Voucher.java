
package com.nmnd.d_book_backend.entity;

import com.nmnd.d_book_backend.enums.DiscountType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // cac chuoi random ngau nhien
    int id;
    String code;
    String name;
    String description;
    DiscountType discountType;
    BigDecimal discountValue;
    BigDecimal maxDiscount;
    BigDecimal minPurchase;
    LocalDate startDate;
    LocalDate endDate;
    int quantity;
    boolean active;

    LocalDateTime createdTime;
    LocalDateTime updatedTime;

    @OneToMany(mappedBy = "voucher")
    List<Receipt> receipts;
}
