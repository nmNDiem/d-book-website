package com.nmnd.d_book_backend.service;

import com.nmnd.d_book_backend.dto.request.CategoryRequest;
import com.nmnd.d_book_backend.dto.response.CategoryResponse;
import com.nmnd.d_book_backend.entity.Category;
import com.nmnd.d_book_backend.mapper.CategoryMapper;
import com.nmnd.d_book_backend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepo;
    @Autowired
    private CategoryMapper categoryMapper;

    public CategoryResponse createCategory(CategoryRequest request) {
        Category category = categoryMapper.toCategory(request);
        category = categoryRepo.save(category);
        return categoryMapper.toCategoryResponse(category);
    }

    public List<CategoryResponse> getAllCategory() {
        var categories = categoryRepo.findAll();

        return categories.stream().map(categoryMapper::toCategoryResponse).toList();
    }

    public void deleteCategory(int id) {
        categoryRepo.deleteById(id);
    }
}
