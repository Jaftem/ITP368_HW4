// Jeremy Aftem
// ITP 368, Fall 2017
// Assign 04
// aftem@usc.edu

public enum Size {
	SMALL (4.25, 10), MEDIUM (6.00, 20),  LARGE(7.75, 35);
	private final double price;
	private final int ounces;
	private Size(double price, int ounces) {
		this.price = price;
		this.ounces = ounces;
	}
	public double getPrice() {
		return price;
	}
	public int getOunces() {
		return ounces;
	}
}