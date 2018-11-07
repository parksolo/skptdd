package step1;

class Rental {
	private Movie movie;
	private int daysRented;

	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public Movie getMovie() {
		return movie;
	}

	double amountFor() {
		return movie.amountFor(daysRented);
	}

	int getFrequentRenterPoints() {
		int daysRented = getDaysRented();
		return movie.getFrequentRenterPoints(daysRented);
	}

}