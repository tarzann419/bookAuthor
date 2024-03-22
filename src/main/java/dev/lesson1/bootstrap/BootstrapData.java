package dev.lesson1.bootstrap;

import dev.lesson1.domain.Author;
import dev.lesson1.domain.Book;
import dev.lesson1.domain.Publisher;
import dev.lesson1.repository.AuthorRepo;
import dev.lesson1.repository.BookRepo;
import dev.lesson1.repository.PublisherRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;
    private final PublisherRepo publisherRepo;

    public BootstrapData(AuthorRepo authorRepo, BookRepo bookRepo, PublisherRepo publisherRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.publisherRepo = publisherRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Watson");

        Book ddd = new Book();
        ddd.setTitle("Domain Driven Desgin");
        ddd.setIsbn("123456");

        Author ericSaved = authorRepo.save(eric);
        Book dddSaved = bookRepo.save(ddd);

        // second entity
        Author rod = new Author();
        eric.setFirstName("Rod");
        eric.setLastName("jamedson");

        Book readAlways = new Book();
        ddd.setTitle("read all the time");
        ddd.setIsbn("334433");

        Author rodSaved = authorRepo.save(rod);
        Book readAlwaysSaved = bookRepo.save(readAlways);

        // creating the association between the 2
        rodSaved.getBooks().add(readAlwaysSaved);
        ericSaved.getBooks().add(dddSaved);

        Publisher publisher = new Publisher();
        publisher.setPublisherName("First Publish");
        publisher.setAddress("emory oak st.");
        Publisher savedPublisher = publisherRepo.save(publisher);

//        both books to the same publisher
        dddSaved.setPublisher(savedPublisher);
        readAlwaysSaved.setPublisher(savedPublisher);


        // savong/persisting the new association
        authorRepo.save(rodSaved);
        authorRepo.save(ericSaved);

        bookRepo.save(dddSaved);
        bookRepo.save(readAlwaysSaved);

        System.out.println("author count: " + authorRepo.count());
        System.out.println("book count: " + bookRepo.count());
        System.out.println("publisher count: " + publisherRepo.count());
    }
}
