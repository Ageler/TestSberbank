package com.example.demo.controllers;

import com.example.demo.entity.Book;
import com.example.demo.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/books")
    private List<Book> books() {
        return bookService.getAllBooks();
    }

    @GetMapping("/firstLetter")
    public Map<String, Long> firstLetter() {
        return bookService.booksByFirstLetterStatistics();
    }

    @GetMapping("/books/{letter}")
    public List<Book> getAllBooksByFirstLetter(@PathVariable String letter) {
        return bookService.booksStartsWithThisLetter(letter);
    }


}
