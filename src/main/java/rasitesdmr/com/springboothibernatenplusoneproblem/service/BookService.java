package rasitesdmr.com.springboothibernatenplusoneproblem.service;

import rasitesdmr.com.springboothibernatenplusoneproblem.model.dto.request.BookRequest;
import rasitesdmr.com.springboothibernatenplusoneproblem.model.dto.response.BookResponse;

public interface BookService {

    BookResponse createBook(BookRequest bookRequest);
}
