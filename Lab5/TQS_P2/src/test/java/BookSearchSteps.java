import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class BookSearchSteps {
    Library library = new Library();
    List<Book> result = new ArrayList<>();

    @ParameterType("([0-9]{4})-([0-9]{2})-([0-9]{2})")
    public LocalDateTime iso8601Date(String year, String month, String day){
        return LocalDateTime.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day),0, 0);
    }



    @Given("(a|another) book with the title {string}, written by {string}, published in {iso8601Date}")
    public void addNewBook(final String title, final String author,  final LocalDateTime published) {
        Book book = new Book(title, author, published);
        library.addBook(book);
    }

    @When("the customer searches for books published between {iso8601Date} and {iso8601Date}")
    public void setSearchParameters(final LocalDateTime from, final LocalDateTime to) {
        result = library.findBooksByDate(from, to);
    }

    @Then("{int} books should have been found")
    public void verifyAmountOfBooksFound(final int booksFound) {
        assertThat(result.size(), equalTo(booksFound));
    }

    @Then("Book {int} should have the title {string}")
    public void verifyBookAtPosition(final int position, final String title) {
        assertThat(result.get(position - 1).getTitle(), equalTo(title));
    }


    @When("the customer searches for books by {string}")
    public void searchByAuthor(String author ) {
        result = library.findBooksByAuthor(author);
    }

    @When("the customer searches for books with title similar to {string}")
    public void searchByExpression(String expression) {
        result = library.findBooksByTitle(expression);
    }
}