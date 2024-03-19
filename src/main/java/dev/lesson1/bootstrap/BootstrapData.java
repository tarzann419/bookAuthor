package dev.lesson1.bootstrap;

import dev.lesson1.domain.Author;
import dev.lesson1.domain.Book;
import dev.lesson1.repository.AuthorRepo;
import dev.lesson1.repository.BookRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;

    public BootstrapData(AuthorRepo authorRepo, BookRepo bookRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Watson");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Desgin");
        ddd.setIsbn("123456");

        authorRepo.save(eric);
    }
}
