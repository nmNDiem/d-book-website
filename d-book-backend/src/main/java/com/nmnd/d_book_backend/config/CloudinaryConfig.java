package com.nmnd.d_book_backend.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {
    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dgcezbyyd",
                "api_key", "959814221454165",
                "api_secret", "SCNdzcyfAjuekjMf2GjM0QqgKvY"));
    }
}
