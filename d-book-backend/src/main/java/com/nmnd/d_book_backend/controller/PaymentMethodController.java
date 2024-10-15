package com.nmnd.d_book_backend.controller;

import com.nmnd.d_book_backend.dto.request.PaymentMethodRequest;
import com.nmnd.d_book_backend.dto.response.PaymentMethodResponse;
import com.nmnd.d_book_backend.service.PaymentMethodService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paymentMethods")
@RequiredArgsConstructor
public class PaymentMethodController {
    @Autowired
    private PaymentMethodService paymentMethodService;

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    PaymentMethodResponse createPaymentMethod(@ModelAttribute PaymentMethodRequest request){
        return paymentMethodService.createPaymentMethod(request);
    }

    @GetMapping
    List<PaymentMethodResponse> getAllPaymentMethods() {
        return paymentMethodService.getAllPaymentMethods();
    }

    @GetMapping("/{paymentMethodId}")
    PaymentMethodResponse getPaymentMethod(@PathVariable int paymentMethodId){
        return paymentMethodService.getPaymentMethod(paymentMethodId);
    }

    @PutMapping("/{paymentMethodId}")
    PaymentMethodResponse updatePaymentMethod(@PathVariable int paymentMethodId, @RequestBody PaymentMethodRequest request){
        return paymentMethodService.updatePaymentMethod(paymentMethodId, request);
    }

    @DeleteMapping("/{paymentMethodId}")
    void deletePaymentMethod(@PathVariable int paymentMethodId) {
        paymentMethodService.deletePaymentMethod(paymentMethodId);
    }
}
