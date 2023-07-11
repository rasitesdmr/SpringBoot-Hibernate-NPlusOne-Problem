package rasitesdmr.com.springboothibernatenplusoneproblem.service;

import org.springframework.stereotype.Service;
import rasitesdmr.com.springboothibernatenplusoneproblem.model.Author;
import rasitesdmr.com.springboothibernatenplusoneproblem.model.Book;
import rasitesdmr.com.springboothibernatenplusoneproblem.model.dto.request.BookRequest;
import rasitesdmr.com.springboothibernatenplusoneproblem.model.dto.response.AuthorResponse;
import rasitesdmr.com.springboothibernatenplusoneproblem.model.dto.response.BookResponse;
import rasitesdmr.com.springboothibernatenplusoneproblem.repository.BookRepository;
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    @Override
    public BookResponse createBook(BookRequest bookRequest) {
        Author author = authorService.getAuthorByAuthorId(bookRequest.getAuthorId());
        Book book = new Book(bookRequest.getTitle(),author);
        bookRepository.save(book);
        return new BookResponse(book.getId(),book.getTitle());
    }
}
