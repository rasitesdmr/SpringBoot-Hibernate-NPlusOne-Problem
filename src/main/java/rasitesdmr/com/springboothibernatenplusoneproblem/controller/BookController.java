package rasitesdmr.com.springboothibernatenplusoneproblem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rasitesdmr.com.springboothibernatenplusoneproblem.model.dto.request.BookRequest;
import rasitesdmr.com.springboothibernatenplusoneproblem.model.dto.response.BookResponse;
import rasitesdmr.com.springboothibernatenplusoneproblem.service.BookService;

@RestController
@RequestMapping(path = "/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(path = "")
    public ResponseEntity<BookResponse> createBook(@RequestBody BookRequest bookRequest) {
        return new ResponseEntity<>(bookService.createBook(bookRequest), HttpStatus.CREATED);
    }
}
