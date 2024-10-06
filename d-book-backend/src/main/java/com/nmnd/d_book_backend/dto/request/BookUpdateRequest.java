package com.nmnd.d_book_backend.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookUpdateRequest {
    String title;
    int pages;
    String isbn;
    String description;
    int publishedYear;
    String image;
    BigDecimal price;
    BigDecimal discountPercent;
    int stock;
    boolean active;
    int categoryId;
    int authorId;
    int publisherId;
}
