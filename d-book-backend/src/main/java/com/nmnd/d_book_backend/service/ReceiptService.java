package com.nmnd.d_book_backend.service;

import com.nmnd.d_book_backend.dto.request.AuthorRequest;
import com.nmnd.d_book_backend.dto.request.ReceiptDetailsRequest;
import com.nmnd.d_book_backend.dto.request.ReceiptRequest;
import com.nmnd.d_book_backend.dto.response.AuthorResponse;
import com.nmnd.d_book_backend.dto.response.ReceiptResponse;
import com.nmnd.d_book_backend.entity.*;
import com.nmnd.d_book_backend.mapper.AuthorMapper;
import com.nmnd.d_book_backend.mapper.ReceiptDetailsMapper;
import com.nmnd.d_book_backend.mapper.ReceiptMapper;
import com.nmnd.d_book_backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReceiptService {
    @Autowired
    private ReceiptRepository receiptRepo;
    @Autowired
    private ReceiptDetailsRepository detailsRepo;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private PaymentMethodRepository paymentMethodRepo;
    @Autowired
    private BookRepository bookRepo;

    @Autowired
    private ReceiptMapper receiptMapper;
    @Autowired
    private ReceiptDetailsMapper detailsMapper;

    @Transactional
    public ReceiptResponse createReceipt(ReceiptRequest request) {
        // Kiểm tra xem userId có tồn tại không
        User user = null;
        if (request.getUserId() != null) {
            user = userRepo.findById(request.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
        }

        PaymentMethod paymentMethod = paymentMethodRepo.findById(request.getPaymentMethodId())
                .orElseThrow(() -> new RuntimeException("Payment method not found"));

        Receipt receipt = receiptMapper.toReceipt(request);
        receipt.setPaymentMethod(paymentMethod);
        receipt.setCreatedTime(LocalDateTime.now());
        receipt.setPaymentTime(LocalDateTime.now());
        receipt.setStatus("Chờ xác nhận");

        if (user != null) {
            receipt.setUser(user);
        }

        for (ReceiptDetailsRequest detailsRequest : request.getDetailsRequests()) {
            Book book = bookRepo.findById(detailsRequest.getBookId())
                    .orElseThrow(() -> new RuntimeException("Book not found"));

            ReceiptDetails details = detailsMapper.toReceiptDetails(detailsRequest);
            details.setBook(book);
            details.setReceipt(receipt);

            details = detailsRepo.save(details);

            receipt.getReceiptDetails().add(details);
        }

        receipt = receiptRepo.save(receipt);

        return receiptMapper.toReceiptResponse(receipt);
    }

    public List<ReceiptResponse> getAllReceipts() {
        var receipts = receiptRepo.findAll();

        return receipts.stream().map(receiptMapper::toReceiptResponse).toList();
    }

    public ReceiptResponse getReceipt(int id) {
        Receipt receipt = receiptRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Receipt not found"));

        return receiptMapper.toReceiptResponse(receipt);
    }
}
