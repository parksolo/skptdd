package step1;

public class RegularMovie extends Movie {
    public RegularMovie(String title) {
        super(title, Movie.REGULAR);
    }

    @Override
    double amountFor(int daysRented) {
        double thisAmount = 0;
        switch (getPriceCode()) {
            case REGULAR:
                thisAmount += 2;
                if (daysRented > 2)
                    thisAmount += (daysRented - 2) * 1.5;
                break;

            case NEW_RELEASE:
                thisAmount += daysRented * 3;
                break;

            case CHILDRENS:
                thisAmount += 1.5;
                if (daysRented > 3)
                    thisAmount += (daysRented - 3) * 1.5;
                break;
        }
        return thisAmount;
    }
}
