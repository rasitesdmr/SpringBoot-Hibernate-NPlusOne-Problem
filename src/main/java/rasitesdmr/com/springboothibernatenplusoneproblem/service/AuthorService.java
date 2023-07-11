package rasitesdmr.com.springboothibernatenplusoneproblem.service;

import rasitesdmr.com.springboothibernatenplusoneproblem.model.Author;
import rasitesdmr.com.springboothibernatenplusoneproblem.model.dto.request.AuthorRequest;
import rasitesdmr.com.springboothibernatenplusoneproblem.model.dto.response.AuthorResponse;
import rasitesdmr.com.springboothibernatenplusoneproblem.repository.AuthorRepository;

import java.util.List;

public interface AuthorService{

    AuthorResponse createAuthor(AuthorRequest authorRequest);
    AuthorResponse getAuthorResponseByAuthorId(Long authorId);
    Author getAuthorByAuthorId(Long authorId);

   List<AuthorResponse >getAllAuthorsQuery();

    List<Author> getAllAuthors();


}
