package com.nmnd.d_book_backend.repository;

import com.nmnd.d_book_backend.entity.Author;
import com.nmnd.d_book_backend.entity.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Integer> {
}
