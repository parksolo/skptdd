package step1;

import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    public static final int TWO_DAYS = 2;
    public static final int THREE_DAYS = 3;

    String name = null;
    Customer customer = new Customer(name);

    @Test
    public void statement_should_X() {

        // Act - When - Test
        String statement = customer.statement();

        // Assert - Then - Post-Condition
        assertEquals("Rental Record for null\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter pointers", statement);
    }

    @Test
    public void statement_should_Y_regularMovie() {
        customer.addRental(createRentalFor(TWO_DAYS));

        String statement = customer.statement();

        assertEquals("Rental Record for null\n" +
                "\t2.0(null)\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter pointers", statement);
    }

    @Test
    public void statement_should_Y_regularMovie_daysRented_is_larger_than_2_days() {
        customer.addRental(createRentalFor(THREE_DAYS));

        String statement = customer.statement();

        assertEquals("Rental Record for null\n" +
                "\t3.5(null)\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter pointers", statement);
    }

    private Rental createRentalFor(int daysRented) {
        String title = null;
        int priceCode = Movie.REGULAR;
        Movie movie = new Movie(title, priceCode);
        return new Rental(movie, daysRented);
    }
}