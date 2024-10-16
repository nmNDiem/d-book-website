
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
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // cac chuoi random ngau nhien
    int id;
    String name;
    @Column(columnDefinition = "LONGTEXT")
    String bio;
    LocalDateTime createdTime;
    LocalDateTime updatedTime;
    @OneToMany(mappedBy = "author")
    Set<Book> books;
}
