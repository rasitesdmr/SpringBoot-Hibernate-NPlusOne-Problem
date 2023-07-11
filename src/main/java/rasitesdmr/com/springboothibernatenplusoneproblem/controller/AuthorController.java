package rasitesdmr.com.springboothibernatenplusoneproblem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rasitesdmr.com.springboothibernatenplusoneproblem.model.Author;
import rasitesdmr.com.springboothibernatenplusoneproblem.model.dto.request.AuthorRequest;
import rasitesdmr.com.springboothibernatenplusoneproblem.model.dto.response.AuthorResponse;
import rasitesdmr.com.springboothibernatenplusoneproblem.service.AuthorService;

import java.util.List;


@RestController()
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping(path = "")
    public ResponseEntity<AuthorResponse> createAuthor(@RequestBody AuthorRequest authorRequest) {
        return new ResponseEntity<>(authorService.createAuthor(authorRequest), HttpStatus.CREATED);
    }

    @GetMapping(path = "/query")
    public ResponseEntity<List<AuthorResponse>> getAllAuthorsQuery() {
        return new ResponseEntity<>(authorService.getAllAuthorsQuery(), HttpStatus.OK);
    }


    @GetMapping(path = "")
    public ResponseEntity<List<Author>> getAllAuthors() {
        return new ResponseEntity<>(authorService.getAllAuthors(), HttpStatus.OK);
    }

}
