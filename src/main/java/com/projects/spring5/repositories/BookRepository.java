package com.projects.spring5.repositories;

import com.projects.spring5.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
