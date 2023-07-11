package rasitesdmr.com.springboothibernatenplusoneproblem.service;

import org.springframework.stereotype.Service;
import rasitesdmr.com.springboothibernatenplusoneproblem.model.Author;
import rasitesdmr.com.springboothibernatenplusoneproblem.model.Book;
import rasitesdmr.com.springboothibernatenplusoneproblem.model.dto.request.AuthorRequest;
import rasitesdmr.com.springboothibernatenplusoneproblem.model.dto.response.AuthorResponse;
import rasitesdmr.com.springboothibernatenplusoneproblem.model.dto.response.BookResponse;
import rasitesdmr.com.springboothibernatenplusoneproblem.repository.AuthorRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public AuthorResponse createAuthor(AuthorRequest authorRequest) {
        Author author = new Author(authorRequest.getFirstName(), authorRequest.getLastName(), authorRequest.getBirthDate());
        authorRepository.save(author);
        return new AuthorResponse(author.getId(), author.getFirstName(), author.getLastName(), author.getBirthDate(),null);
    }

    @Override
    public AuthorResponse getAuthorResponseByAuthorId(Long authorId) {
        Author author = getAuthorByAuthorId(authorId);
        return new AuthorResponse(author.getId(),author.getFirstName(),author.getLastName(),author.getBirthDate(),null);
    }

    @Override
    public Author getAuthorByAuthorId(Long authorId) {
        return authorRepository.findById(authorId).orElseThrow(() -> new RuntimeException(""));
    }

    @Override
    public List<AuthorResponse> getAllAuthorsQuery() {
        List<Author> authors = authorRepository.findAllWithBooks();
        Set<BookResponse> bookResponses = new HashSet<>();
        List<AuthorResponse> authorResponses = new ArrayList<>();
        for (Author author : authors){
            AuthorResponse authorResponse = new AuthorResponse(author.getId(),author.getFirstName(),author.getLastName(),author.getBirthDate(),null);
            System.out.println("Author name: " + author.getFirstName());
            for (Book book : author.getBooks()){
                BookResponse bookResponse = new BookResponse(book.getId(),book.getTitle());
                authorResponse.setBookResponses(bookResponses);
                System.out.println("Book title: " + book.getTitle());
                bookResponses.add(bookResponse);
            }
            authorResponses.add(authorResponse);
        }
        return authorResponses;
    }



    @Override
    public List<Author> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        for (Author author : authors) {
            System.out.println("Author name: " + author.getFirstName());
            for (Book book : author.getBooks()) {
                System.out.println("Book title: " + book.getTitle());
            }
        }
        return authors;
    }

}
