package rasitesdmr.com.springboothibernatenplusoneproblem.model.dto.response;


import java.util.Set;

public class AuthorResponse {
    private Long id;

    private String firstName;

    private String lastName;

    private String birthDate;

    private Set<BookResponse> bookResponses;

    public AuthorResponse() {
    }

    public AuthorResponse(Long id, String firstName, String lastName, String birthDate,Set<BookResponse> bookResponses) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.bookResponses=bookResponses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Set<BookResponse> getBookResponses() {
        return bookResponses;
    }

    public void setBookResponses(Set<BookResponse> bookResponses) {
        this.bookResponses = bookResponses;
    }
}
