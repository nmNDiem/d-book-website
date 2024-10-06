package com.nmnd.d_book_backend.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorResponse {
    int id;
    String name;
    String bio;
    LocalDateTime createdTime;
    LocalDateTime updatedTime;
}
