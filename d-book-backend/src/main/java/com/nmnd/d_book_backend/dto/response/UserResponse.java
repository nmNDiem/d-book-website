package com.nmnd.d_book_backend.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    String id;
    String email;
    String fullName;
    LocalDate dob;
    String title;
    String phone;
    String address;
    String image;
    boolean active;

    LocalDateTime createdTime;
    LocalDateTime updatedTime;
}
