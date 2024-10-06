package com.nmnd.d_book_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String phone;
    String email;
    String address;
    boolean active;

    LocalDateTime createdTime;
    LocalDateTime updatedTime;

    @OneToMany(mappedBy = "supplier")
    Set<GoodsReceipt> goodsReceipts;
}
