package com.springfwcourse.spring5webapp.bootstrap;

import com.springfwcourse.spring5webapp.model.Author;
import com.springfwcourse.spring5webapp.model.Book;
import com.springfwcourse.spring5webapp.model.Publisher;
import com.springfwcourse.spring5webapp.repositories.AuthorRepository;
import com.springfwcourse.spring5webapp.repositories.BookRepository;
import com.springfwcourse.spring5webapp.repositories.PublisherRepository;
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
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Author eric = new Author("Eric", "Evans");
        Publisher p1 = new Publisher("Harper Collins","195 Broadway New York");
        Book ddd = new Book("Domain Driven Design", "1234", p1);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        publisherRepository.save(p1);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Publisher p2 = new Publisher("Worx","400 Applewood Crescent Vaughan Canada");
        Book noEJB = new Book("J2EE Development Without EJB", "23566", p2);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        publisherRepository.save(p2);
        bookRepository.save(noEJB);
    }
}
