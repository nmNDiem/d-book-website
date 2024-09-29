
package com.nmnd.d_book_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // cac chuoi random ngau nhien
    int id;
    int rating;
    String comment;
    LocalDateTime createdTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User userId;

    @ManyToOne
    @JoinColumn(name = "book_id")
    Book bookId;
}
