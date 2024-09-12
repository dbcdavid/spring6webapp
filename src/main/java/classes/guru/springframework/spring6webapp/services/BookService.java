package classes.guru.springframework.spring6webapp.services;

import classes.guru.springframework.spring6webapp.domain.Book;

public interface BookService {

    Iterable<Book> findAll();
}
