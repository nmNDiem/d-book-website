package com.nmnd.d_book_backend.dto.request;

import com.nmnd.d_book_backend.entity.Author;
import com.nmnd.d_book_backend.entity.Category;
import com.nmnd.d_book_backend.entity.Publisher;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookCreationRequest {
    String title;
    int pages;
    String isbn;
    String description;
    int publishedYear;
    MultipartFile image;
    BigDecimal price;
    BigDecimal discountPercent;
    int stock;
    boolean active;
    int categoryId;
    int authorId;
    int publisherId;
}
