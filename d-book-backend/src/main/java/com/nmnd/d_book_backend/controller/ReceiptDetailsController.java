package com.nmnd.d_book_backend.controller;

import com.nmnd.d_book_backend.dto.request.AuthorRequest;
import com.nmnd.d_book_backend.dto.response.AuthorResponse;
import com.nmnd.d_book_backend.dto.response.ReceiptDetailsResponse;
import com.nmnd.d_book_backend.repository.ReceiptDetailsRepository;
import com.nmnd.d_book_backend.service.AuthorService;
import com.nmnd.d_book_backend.service.ReceiptDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receipt-details")
@RequiredArgsConstructor
public class ReceiptDetailsController {
    @Autowired
    private ReceiptDetailsService detailsService;

    @GetMapping
    List<ReceiptDetailsResponse> getAllReceiptDetails() {
        return detailsService.getAllReceiptDetails();
    }
}
