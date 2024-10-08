package com.nmnd.d_book_backend.service;

import com.nmnd.d_book_backend.dto.request.ReceiptDetailsRequest;
import com.nmnd.d_book_backend.dto.request.ReceiptRequest;
import com.nmnd.d_book_backend.dto.response.ReceiptDetailsResponse;
import com.nmnd.d_book_backend.dto.response.ReceiptResponse;
import com.nmnd.d_book_backend.entity.*;
import com.nmnd.d_book_backend.mapper.ReceiptDetailsMapper;
import com.nmnd.d_book_backend.mapper.ReceiptMapper;
import com.nmnd.d_book_backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReceiptDetailsService {
    @Autowired
    private ReceiptDetailsRepository detailsRepo;

    @Autowired
    private ReceiptDetailsMapper detailsMapper;

    public List<ReceiptDetailsResponse> getAllReceiptDetails() {
        var details = detailsRepo.findAll();

        return details.stream().map(detailsMapper::toReceiptDetailsResponse).toList();
    }
}
