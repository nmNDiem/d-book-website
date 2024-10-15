package com.nmnd.d_book_backend.controller;

import com.nmnd.d_book_backend.dto.request.BannerRequest;
import com.nmnd.d_book_backend.dto.request.PublisherRequest;
import com.nmnd.d_book_backend.dto.response.BannerResponse;
import com.nmnd.d_book_backend.dto.response.PublisherResponse;
import com.nmnd.d_book_backend.service.BannerService;
import com.nmnd.d_book_backend.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/banners")
@RequiredArgsConstructor
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    BannerResponse createBanner(@ModelAttribute BannerRequest request) throws IOException {
        return bannerService.createBanner(request);
    }

    @GetMapping
    List<BannerResponse> getAllBanner() {
        return bannerService.getAllBanner();
    }

    @DeleteMapping("/{bannerId}")
    void deleteBanner(@PathVariable int bannerId) {
        bannerService.deleteBanner(bannerId);
    }
}
