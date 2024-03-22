package dev.lesson1.services;

import dev.lesson1.domain.Author;
import dev.lesson1.repository.AuthorRepo;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepo authorRepo;

    public AuthorServiceImpl(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    @Override
    public Iterable<Author> allAuthors() {
        return authorRepo.findAll();
    }
}
