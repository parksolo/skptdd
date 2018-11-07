package step1;

import java.util.ArrayList;
import java.util.List;

class Customer {
	private String name;
	private List<Rental> rentals = new ArrayList<>();

	public Customer(String name) {
		this.name = name;
	};

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String getName() {
		return name;
	};

	public String statement() {
		return statementHeader()
			   + statementBody()
			   + statementTail();
	}

	private String statementTail() {
		String result = "Amount owed is " + String.valueOf(getTotalAmount()) + "\n";
		result += "You earned " + String.valueOf(getFrequentRenterPoints()) + " frequent renter pointers";
		return result;
	}

	private String statementBody() {
		return getRentaLines();
	}

	private String statementHeader() {
		return "Rental Record for " + getName() + "\n";
	}

	private double getTotalAmount() {
		double totalAmount = 0;
		for ( Rental each : rentals ) {
			totalAmount += each.amountFor();
		}
		return totalAmount;
	}

	private String getRentaLines() {
		String result = "";
		for ( Rental each : rentals ) {
			result += showRentalLines(each, each.amountFor());
		}
		return result;
	}

	private int getFrequentRenterPoints() {
		int frequentRenterPoints = 0;
		for ( Rental each : rentals ) {
			frequentRenterPoints += each.getFrequentRenterPoints();
		}
		return frequentRenterPoints;
	}

	private String showRentalLines(Rental each, double thisAmount) {
		String result = "\t" + String.valueOf(thisAmount) + "(" + each.getMovie().getTitle() + ")" + "\n";
		return result;
	}

}