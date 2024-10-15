package com.nmnd.d_book_backend.repository;

import com.nmnd.d_book_backend.entity.Banner;
import com.nmnd.d_book_backend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerRepository extends JpaRepository<Banner, Integer> {
}
