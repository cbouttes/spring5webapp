package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher eni = new Publisher("ENI", "13 r Calais","Paris","FRANCE","75009");

        publisherRepository.save(eni);

        System.out.println("Editeur eni : " + eni);
        System.out.println("Number of Publisher: " + publisherRepository.count());

        Author eric = new Author("Eric","Evans");
        Book bookDdd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(bookDdd);
        bookDdd.getAuthors().add(eric);
        bookDdd.setPublisher(eni);
        System.out.println("Publisher of book " + bookDdd.getTitle() + " : " + bookDdd.getPublisher().getName());

        authorRepository.save(eric);
        bookRepository.save(bookDdd);

        Author rod = new Author("Rod", "Johnson");
        Book bookNoEJB = new Book("J2EE Development without EJB", "3939459459");
        rod.getBooks().add(bookNoEJB);
        bookNoEJB.getAuthors().add(rod);
        bookNoEJB.setPublisher(eni);
        System.out.println("Publisher of " + bookNoEJB.getTitle() + " : " + bookNoEJB.getPublisher().getName());

        authorRepository.save(rod);
        bookRepository.save(bookNoEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());

        eni.getBooks().add(bookDdd);
        eni.getBooks().add(bookNoEJB);
        System.out.println("Number of books for ENI publisher: " + eni.getBooks().size());

        publisherRepository.save(eni);


    }

}
