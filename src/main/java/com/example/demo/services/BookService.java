package com.example.demo.services;

import com.example.demo.entity.Book;
import com.example.demo.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BookService {

    private final List<String> alphabet = List.of("й", "ц", "у", "к", "е", "н", "г", "ш", "щ", "з", "х", "ф", "ы", "в", "а", "п", "р", "о", "л", "д", "ж", "э", "я", "ч", "с", "м", "и", "т", "ь", "б", "ю", "ъ", "ё");


    private final BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Map<String, Long> booksByFirstLetterStatistics() {
        List<Book> books = bookRepository.findAll();
        Map<String, Long> bookStatistic = new HashMap<>();
        for (Book book: books) {
           String key  = String.valueOf(book.getName().toLowerCase(Locale.ROOT).charAt(0));
           if(!bookStatistic.containsKey(key)) {
               bookStatistic.put(key, 1l);
           } else {
               bookStatistic.computeIfPresent(key, (k, v)-> {v = v + 1; return v;});
           }
        }
        return bookStatistic;
    }
        public List<Book> booksStartsWithThisLetter(String firstLetter){
            return bookRepository.findBooksByNameStartsWith(firstLetter);
        }

    }

