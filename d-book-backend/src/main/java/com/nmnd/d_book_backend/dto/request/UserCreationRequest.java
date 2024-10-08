package com.nmnd.d_book_backend.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
    String email;
    String password;
    String fullName;
    LocalDate dob;
    String title;
    String phone;
    String address;
    String avatar;
    boolean active;
}
