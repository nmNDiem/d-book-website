
package com.nmnd.d_book_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    BigDecimal totalPrice;
    LocalDateTime createdTime;
    LocalDateTime paymentTime;
    String status;

    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    PaymentMethod paymentMethodId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User userId;

    @OneToMany(mappedBy = "receiptId")
    List<ReceiptDetails> receiptDetails;

    @ManyToOne
    @JoinColumn(name = "voucher_id")
    Voucher voucherId;
}
