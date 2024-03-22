package dev.lesson1.services;

import dev.lesson1.domain.Author;

public interface AuthorService {
    Iterable<Author> allAuthors();
}
