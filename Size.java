// Jeremy Aftem
// ITP 368, Fall 2017
// Assign 04
// aftem@usc.edu

public enum Size {
	SMALL_BOWL (4.25, 10), MEDIUM_BOWL (6.00, 20),  LARGE_BOWL (7.75, 35),
	SMALL_CONE (4.25, 8),  MEDIUM_CONE (6.00, 15),  LARGE_CONE (7.75, 25);
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