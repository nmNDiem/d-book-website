package com.nmnd.d_book_backend.controller;

import com.nmnd.d_book_backend.dto.request.PublisherRequest;
import com.nmnd.d_book_backend.dto.response.PublisherResponse;
import com.nmnd.d_book_backend.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publishers")
@RequiredArgsConstructor
public class PublisherController {
    @Autowired
    private PublisherService publisherService;

    @PostMapping
    PublisherResponse createPublisher(@RequestBody PublisherRequest request){
        return publisherService.createPublisher(request);
    }

    @GetMapping
    List<PublisherResponse> getAllPublisher() {
        return publisherService.getAllPublisher();
    }

    @DeleteMapping("/{publisherId}")
    void deletePublisher(@PathVariable int publisherId) {
        publisherService.deletePublisher(publisherId);
    }
}
