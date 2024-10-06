package com.nmnd.d_book_backend.service;

import com.nmnd.d_book_backend.dto.request.AuthorRequest;
import com.nmnd.d_book_backend.dto.response.AuthorResponse;
import com.nmnd.d_book_backend.entity.Author;
import com.nmnd.d_book_backend.mapper.AuthorMapper;
import com.nmnd.d_book_backend.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepo;
    @Autowired
    private AuthorMapper authorMapper;

    public AuthorResponse createAuthor(AuthorRequest request) {
        Author author = authorMapper.toAuthor(request);
        author.setCreatedTime(LocalDateTime.now());
        author.setUpdatedTime(LocalDateTime.now());

        author = authorRepo.save(author);

        return authorMapper.toAuthorResponse(author);
    }

    public List<AuthorResponse> getAllAuthors() {
        var authors = authorRepo.findAll();

        return authors.stream().map(authorMapper::toAuthorResponse).toList();
    }

    public AuthorResponse getAuthor(int id) {
        Author author = authorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        return authorMapper.toAuthorResponse(author);
    }

    public AuthorResponse updateAuthor(int id, AuthorRequest request) {
        Author author = authorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        authorMapper.updateAuthor(author, request);

        return authorMapper.toAuthorResponse(author);
    }

    public void deleteAuthor(int id) {
        authorRepo.deleteById(id);
    }
}
