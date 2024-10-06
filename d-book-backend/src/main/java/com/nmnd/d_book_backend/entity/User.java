package com.nmnd.d_book_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)   // cac chuoi random ngau nhien
    String id;
    String email;
    String password;
    String fullName;
    LocalDate dob;
    String title;
    String phone;
    String address;
    String avatar;
    boolean active;

    LocalDateTime createdTime;
    LocalDateTime updatedTime;

//    @ManyToMany
//    Set<Role> roles;

    @OneToMany(mappedBy = "user")
    List<Receipt> receipts;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    Cart cart;

    @OneToMany(mappedBy = "user")
    List<Review> reviews;
}
