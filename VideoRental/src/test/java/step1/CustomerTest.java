package step1;

import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    public static final int TWO_DAYS = 2;
    public static final int THREE_DAYS = 3;
    public static final int FOUR_DAYS = 4;
    public static final int ONE_DAY = 1;

    String name = "CUSTOMER_NAME_NOT_IMPORTANT";
    Customer customer = new Customer(name);

    @Test
    public void statement_for_noRental() {

        // Act - When - Test
        String statement = customer.statement();

        // Assert - Then - Post-Condition
        assertEquals("Rental Record for CUSTOMER_NAME_NOT_IMPORTANT\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter pointers", statement);
    }

    @Test
    public void statement_for_regularMovie_when_rents_less_than_3_days() {
        customer.addRental(createRentalFor(TWO_DAYS));

        String statement = customer.statement();

        assertEquals("Rental Record for CUSTOMER_NAME_NOT_IMPORTANT\n" +
                "\t2.0(TITLE_NOT_IMPORTANT)\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter pointers", statement);
    }

    @Test
    public void statement_for_regularMovie_daysRented_is_larger_than_2_days() {
        customer.addRental(createRentalFor(THREE_DAYS));

        String statement = customer.statement();

        assertEquals("Rental Record for CUSTOMER_NAME_NOT_IMPORTANT\n" +
                "\t3.5(TITLE_NOT_IMPORTANT)\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter pointers", statement);
    }

    @Test
    public void statement_for_newReleaseMovie_() {
        customer.addRental(createRentalFor(Movie.NEW_RELEASE, TWO_DAYS));

        String statement = customer.statement();

        assertEquals("Rental Record for CUSTOMER_NAME_NOT_IMPORTANT\n" +
                "\t6.0(TITLE_NOT_IMPORTANT)\n" +
                "Amount owed is 6.0\n" +
                "You earned 2 frequent renter pointers", statement);
    }

    @Test
    public void statement_for_newReleaseMovie_when_rents_less_than_2_days() {
        customer.addRental(createRentalFor(Movie.NEW_RELEASE, 1));

        String statement = customer.statement();

        assertEquals("Rental Record for CUSTOMER_NAME_NOT_IMPORTANT\n" +
                "\t3.0(TITLE_NOT_IMPORTANT)\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter pointers", statement);
    }

    @Test
    public void statement_for_childrensMovie_when_rents_less_than_4_days() {
        customer.addRental(createRentalFor(Movie.CHILDRENS, THREE_DAYS));

        String statement = customer.statement();

        assertEquals("Rental Record for CUSTOMER_NAME_NOT_IMPORTANT\n" +
                "\t1.5(TITLE_NOT_IMPORTANT)\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter pointers", statement);
    }

    @Test
    public void statement_for_childrensMovie_when_rents_more_than_3_days() {
        customer.addRental(createRentalFor(Movie.CHILDRENS, FOUR_DAYS));

        String statement = customer.statement();

        assertEquals("Rental Record for CUSTOMER_NAME_NOT_IMPORTANT\n" +
                "\t3.0(TITLE_NOT_IMPORTANT)\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter pointers", statement);
    }

    @Test
    public void statement_for_several_movies() {
        customer.addRental(createRentalFor(Movie.REGULAR, TWO_DAYS));
        customer.addRental(createRentalFor(Movie.REGULAR, THREE_DAYS));

        customer.addRental(createRentalFor(Movie.NEW_RELEASE, ONE_DAY));
        customer.addRental(createRentalFor(Movie.NEW_RELEASE, TWO_DAYS));

        customer.addRental(createRentalFor(Movie.CHILDRENS, THREE_DAYS));
        customer.addRental(createRentalFor(Movie.CHILDRENS, FOUR_DAYS));

        String statement = customer.statement();

        assertEquals("Rental Record for CUSTOMER_NAME_NOT_IMPORTANT\n" +
                "\t2.0(TITLE_NOT_IMPORTANT)\n" +
                "\t3.5(TITLE_NOT_IMPORTANT)\n" +
                "\t3.0(TITLE_NOT_IMPORTANT)\n" +
                "\t6.0(TITLE_NOT_IMPORTANT)\n" +
                "\t1.5(TITLE_NOT_IMPORTANT)\n" +
                "\t3.0(TITLE_NOT_IMPORTANT)\n" +
                "Amount owed is 19.0\n" +
                "You earned 7 frequent renter pointers", statement);
    }

    private Rental createRentalFor(int daysRented) {
        return createRentalFor(Movie.REGULAR, daysRented);
    }

    private Rental createRentalFor(int priceCode, int daysRented) {
        String title = "TITLE_NOT_IMPORTANT";
        Movie movie = createMovie(priceCode, title);
        return new Rental(movie, daysRented);
    }

    private Movie createMovie(int priceCode, String title) {
        if ( priceCode == Movie.REGULAR )
            return new RegularMovie(title);

        return new Movie(title, priceCode);
    }
}