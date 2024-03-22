package dev.lesson1.services;

import dev.lesson1.domain.Book;

public interface BookService {
    Iterable<Book> findAll();
}
