package com.nmnd.d_book_backend.service;

import com.nmnd.d_book_backend.dto.request.BannerRequest;
import com.nmnd.d_book_backend.dto.response.BannerResponse;
import com.nmnd.d_book_backend.entity.Banner;
import com.nmnd.d_book_backend.mapper.BannerMapper;
import com.nmnd.d_book_backend.repository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class BannerService {
    @Autowired
    private BannerRepository bannerRepo;
    @Autowired
    private BannerMapper bannerMapper;
    @Autowired
    private ImageService imageService;

    public BannerResponse createBanner(BannerRequest request) throws IOException {
        MultipartFile file = request.getImage();

        Banner banner = bannerMapper.toBanner(request);
        if (file != null && !file.isEmpty()) {
            String imageUrl = imageService.uploadImage(file);     // up len cloudinary, tra ve url
            banner.setImage(imageUrl);
        }

        banner = bannerRepo.save(banner);

        return bannerMapper.toBannerResponse(banner);
    }

    public List<BannerResponse> getAllBanner() {
        var banners = bannerRepo.findAll();

        return banners.stream().map(bannerMapper::toBannerResponse).toList();
    }

    public void deleteBanner(int id) {
        bannerRepo.deleteById(id);
    }
}
