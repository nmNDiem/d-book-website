package com.nmnd.d_book_backend.controller;

import com.nmnd.d_book_backend.dto.request.AuthorRequest;
import com.nmnd.d_book_backend.dto.response.AuthorResponse;
import com.nmnd.d_book_backend.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    AuthorResponse createAuthor(@ModelAttribute AuthorRequest request){
        return authorService.createAuthor(request);
    }

    @GetMapping
    List<AuthorResponse> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{authorId}")
    AuthorResponse getAuthor(@PathVariable int authorId){
        return authorService.getAuthor(authorId);
    }

    @PutMapping("/{authorId}")
    AuthorResponse updateAuthor(@PathVariable int authorId, @RequestBody AuthorRequest request){
        return authorService.updateAuthor(authorId, request);
    }

    @DeleteMapping("/{authorId}")
    void deleteAuthor(@PathVariable int authorId) {
        authorService.deleteAuthor(authorId);
    }
}
