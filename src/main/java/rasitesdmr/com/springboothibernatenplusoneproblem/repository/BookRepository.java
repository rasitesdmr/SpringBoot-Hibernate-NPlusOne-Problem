package rasitesdmr.com.springboothibernatenplusoneproblem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rasitesdmr.com.springboothibernatenplusoneproblem.model.Book;
@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
