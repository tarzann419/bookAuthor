package dev.lesson1.services;

import dev.lesson1.domain.Book;
import dev.lesson1.repository.BookRepo;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepo bookRepo;

    public BookServiceImpl(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepo.findAll();
    }
}
