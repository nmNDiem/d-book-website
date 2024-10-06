package com.nmnd.d_book_backend.dto.response;

import com.nmnd.d_book_backend.entity.Author;
import com.nmnd.d_book_backend.entity.Category;
import com.nmnd.d_book_backend.entity.Publisher;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookResponse {
    int id;
    String title;
    int pages;
    String isbn;
    String description;
    int publishedYear;
    String image;
    BigDecimal price;
    int discountPercent;
    float rating;
    int stock;
    boolean active;

    LocalDateTime createdTime;
    LocalDateTime updatedTime;

    String categoryName;
    String authorName;
    String publisherName;
}
