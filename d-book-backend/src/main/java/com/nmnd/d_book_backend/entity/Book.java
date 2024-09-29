
package com.nmnd.d_book_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // cac chuoi random ngau nhien
    int id;
    String title;
    int pages;
    String ISBN;
    String description;
    int publishedYear;
    String image;
    BigDecimal price;
    int discountPercent;
    float rating;
    int stock;
    boolean isActive;

    LocalDateTime createdTime;
    LocalDateTime updatedTime;

    @ManyToOne
    @JoinColumn(name = "category_id")
    Category categoryId;

    @ManyToOne
    @JoinColumn(name = "author_id")
    Author authorId;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    Publisher publisherId;

    @OneToMany(mappedBy = "bookId")
    List<Review> reviews;

    @OneToMany(mappedBy = "bookId")
    Set<GoodsReceiptDetails> goodsReceiptDetails;

    @OneToMany(mappedBy = "bookId")
    List<ReceiptDetails> receiptDetails;
}
