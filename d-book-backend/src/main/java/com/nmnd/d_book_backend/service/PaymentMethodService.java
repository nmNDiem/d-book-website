package com.nmnd.d_book_backend.service;

import com.nmnd.d_book_backend.dto.request.PaymentMethodRequest;
import com.nmnd.d_book_backend.dto.response.PaymentMethodResponse;
import com.nmnd.d_book_backend.entity.PaymentMethod;
import com.nmnd.d_book_backend.mapper.PaymentMethodMapper;
import com.nmnd.d_book_backend.repository.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentMethodService {
    @Autowired
    private PaymentMethodRepository paymentMethodRepo;
    @Autowired
    private PaymentMethodMapper paymentMethodMapper;

    public PaymentMethodResponse createPaymentMethod(PaymentMethodRequest request) {
        PaymentMethod paymentMethod = paymentMethodMapper.toPaymentMethod(request);
        paymentMethod = paymentMethodRepo.save(paymentMethod);

        return paymentMethodMapper.toPaymentMethodResponse(paymentMethod);
    }

    public List<PaymentMethodResponse> getAllPaymentMethods() {
        var paymentMethods = paymentMethodRepo.findAll();

        return paymentMethods.stream().map(paymentMethodMapper::toPaymentMethodResponse).toList();
    }

    public PaymentMethodResponse getPaymentMethod(int id) {
        PaymentMethod paymentMethod = paymentMethodRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment method not found"));

        return paymentMethodMapper.toPaymentMethodResponse(paymentMethod);
    }

    public PaymentMethodResponse updatePaymentMethod(int id, PaymentMethodRequest request) {
        PaymentMethod paymentMethod = paymentMethodRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment method not found"));

        paymentMethodMapper.updatePaymentMethod(paymentMethod, request);

        return paymentMethodMapper.toPaymentMethodResponse(paymentMethod);
    }

    public void deletePaymentMethod(int id) {
        paymentMethodRepo.deleteById(id);
    }
}
