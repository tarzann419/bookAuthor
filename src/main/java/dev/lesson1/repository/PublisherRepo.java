package dev.lesson1.repository;

import dev.lesson1.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepo extends CrudRepository<Publisher,  Long> {
}
