package com.projects.spring5.repositories;

import com.projects.spring5.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
