package com.nmnd.d_book_backend.controller;

import com.nmnd.d_book_backend.dto.request.AuthorRequest;
import com.nmnd.d_book_backend.dto.request.ReceiptRequest;
import com.nmnd.d_book_backend.dto.response.AuthorResponse;
import com.nmnd.d_book_backend.dto.response.ReceiptResponse;
import com.nmnd.d_book_backend.service.AuthorService;
import com.nmnd.d_book_backend.service.ReceiptService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receipts")
@RequiredArgsConstructor
public class ReceiptController {
    @Autowired
    private ReceiptService receiptService;

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    ReceiptResponse createReceipt(@ModelAttribute ReceiptRequest request){
        return receiptService.createReceipt(request);
    }

    @GetMapping
    List<ReceiptResponse> getAllReceipts() {
        return receiptService.getAllReceipts();
    }

    @GetMapping("/{receiptId}")
    ReceiptResponse getReceipt(@PathVariable int receiptId){
        return receiptService.getReceipt(receiptId);
    }
}
