package classes.guru.springframework.spring6webapp.bootstrap;

import classes.guru.springframework.spring6webapp.domain.Author;
import classes.guru.springframework.spring6webapp.domain.Book;
import classes.guru.springframework.spring6webapp.repositories.AuthorRepository;
import classes.guru.springframework.spring6webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author patrick = new Author();
        patrick.setFirstName("Patrick");
        patrick.setLastName("Rothfuss");

        Book doors = new Book();
        doors.setTitle("Doors of Stone");
        doors.setIsbn("123456789");

        Author patrickSaved = authorRepository.save(patrick);
        Book doorsSaved = bookRepository.save(doors);

        Author george = new Author();
        george.setFirstName("George");
        george.setLastName("Martin");

        Book wind = new Book();
        wind.setTitle("Winds of winter");
        wind.setIsbn("987654321");

        Author georgeSaved = authorRepository.save(george);
        Book windSaved = bookRepository.save(wind);

        patrickSaved.getBooks().add(doorsSaved);
        georgeSaved.getBooks().add(windSaved);

        authorRepository.save(patrickSaved);
        authorRepository.save(georgeSaved);

        System.out.println("In bootstrap");
        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());
    }
}
