package com.nmnd.d_book_backend.controller;

import com.nmnd.d_book_backend.dto.request.CategoryRequest;
import com.nmnd.d_book_backend.dto.response.CategoryResponse;
import com.nmnd.d_book_backend.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    CategoryResponse createCategory(@ModelAttribute CategoryRequest request){
        return categoryService.createCategory(request);
    }

    @GetMapping
    List<CategoryResponse> getAllCategories() {
        return categoryService.getAllCategory();
    }

    @DeleteMapping("/{cateId}")
    void deleteCategory(@PathVariable int cateId) {
        categoryService.deleteCategory(cateId);
    }
}
