package com.nmnd.d_book_backend.controller;

import com.nmnd.d_book_backend.dto.request.BookCreationRequest;
import com.nmnd.d_book_backend.dto.response.BookResponse;
import com.nmnd.d_book_backend.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    BookResponse createBook(@ModelAttribute BookCreationRequest request) throws IOException {
        return bookService.createBook(request);
    }

    @GetMapping
    List<BookResponse> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{bookId}")
    BookResponse getBook(@PathVariable int bookId) {
        return bookService.getBook(bookId);
    }

    @DeleteMapping("/{bookId}")
    void deleteBook(@PathVariable int bookId) {
        bookService.deleteBook(bookId);
    }
}
