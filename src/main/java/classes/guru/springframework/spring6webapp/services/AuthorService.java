package classes.guru.springframework.spring6webapp.services;

import classes.guru.springframework.spring6webapp.domain.Author;

public interface AuthorService {

    Iterable<Author> findAll();
}
