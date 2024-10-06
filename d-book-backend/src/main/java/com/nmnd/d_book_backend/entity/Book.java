
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
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String title;
    int pages;
    String isbn;
    @Column(columnDefinition = "LONGTEXT")
    String description;
    int publishedYear;
    String image;
    BigDecimal price;
    BigDecimal discountPercent;
    float rating;
    int stock;
    boolean active;

    LocalDateTime createdTime;
    LocalDateTime updatedTime;

    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;

    @ManyToOne
    @JoinColumn(name = "author_id")
    Author author;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    Publisher publisher;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    List<Review> reviews;

    @OneToMany(mappedBy = "book")
    Set<GoodsReceiptDetails> goodsReceiptDetails;

    @OneToMany(mappedBy = "book")
    List<ReceiptDetails> receiptDetails;

    @OneToMany(mappedBy = "book")
    List<CartDetails> cartDetails;
}
