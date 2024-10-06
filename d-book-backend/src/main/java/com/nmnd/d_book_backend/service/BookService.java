package com.nmnd.d_book_backend.service;

import com.nmnd.d_book_backend.dto.request.BookCreationRequest;
import com.nmnd.d_book_backend.dto.response.BookResponse;
import com.nmnd.d_book_backend.entity.Author;
import com.nmnd.d_book_backend.entity.Book;
import com.nmnd.d_book_backend.entity.Category;
import com.nmnd.d_book_backend.entity.Publisher;
import com.nmnd.d_book_backend.mapper.BookMapper;
import com.nmnd.d_book_backend.repository.AuthorRepository;
import com.nmnd.d_book_backend.repository.BookRepository;
import com.nmnd.d_book_backend.repository.CategoryRepository;
import com.nmnd.d_book_backend.repository.PublisherRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepo;
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private CategoryRepository categoryRepo;
    @Autowired
    private AuthorRepository authorRepo;
    @Autowired
    private PublisherRepository publisherRepo;

    public BookResponse createBook(BookCreationRequest request) {
        Category category = categoryRepo.getReferenceById(request.getCategoryId());
        Author author = authorRepo.getReferenceById(request.getAuthorId());
        Publisher publisher = publisherRepo.getReferenceById(request.getPublisherId());

        Book book = bookMapper.toBook(request);

        book.setCategory(category);
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setRating(0);
        book.setCreatedTime(LocalDateTime.now());
        book.setUpdatedTime(LocalDateTime.now());

        book = bookRepo.save(book);

        return bookMapper.toBookResponse(book);
    }

    public List<BookResponse> getAllBooks() {
        var books = bookRepo.findAll();

        return books.stream().map(bookMapper::toBookResponse).toList();
    }

    public BookResponse getBook(int id) {
        Book book = bookRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        return bookMapper.toBookResponse(book);
    }

    public void deleteBook(int id) {
        bookRepo.deleteById(id);
    }
}
