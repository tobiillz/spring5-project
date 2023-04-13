package com.projects.spring5.bootstrap;

import com.projects.spring5.model.Author;
import com.projects.spring5.model.Book;
import com.projects.spring5.model.Publisher;
import com.projects.spring5.repositories.AuthorRepository;
import com.projects.spring5.repositories.BookRepository;
import com.projects.spring5.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initData();
    }

    private void initData(){
        //Eric
        Publisher publisher = new Publisher();
        publisher.setName("Samuel");
        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven Design", "1234", publisher);
//        Publisher publisher = new Publisher("Samuel Victor","13, Hawley street idowu martins");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
//        publisher.getPublisher().add(publisher);
        publisherRepository.save(publisher);
        authorRepository.save(eric);
        bookRepository.save(ddd);

//Rod
        Author rod = new Author("Rod","Smith");
        Book noEJB = new Book("J2EE Development without EJB","23444",publisher);
        rod.getBooks().add(noEJB);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}