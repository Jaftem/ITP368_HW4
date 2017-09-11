// Jeremy Aftem
// ITP 368
// HW 04
// aftem@usc.edu

public enum Type {
	SUGAR_FREE(1.00), FAT_FREE(1.00), HALF_AND_HALF(0.50);
	private double price;
	Type (double price) {
		this.price = price;
	}
	public double getPrice() {
		return price;
	}
}
