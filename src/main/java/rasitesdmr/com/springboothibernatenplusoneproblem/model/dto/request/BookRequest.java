package rasitesdmr.com.springboothibernatenplusoneproblem.model.dto.request;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import rasitesdmr.com.springboothibernatenplusoneproblem.model.Author;

public class BookRequest {

    private String title;
    private Long authorId;

    public BookRequest() {
    }

    public BookRequest(String title, Long authorId) {
        this.title = title;
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
