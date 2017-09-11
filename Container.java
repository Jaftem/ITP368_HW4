public enum Container {
	BOWL (0), CONE (1.00); //bowls are free

    private final double price;
	private Container(double price) {
		this.price = price;
	}
	public double getPrice() {
		return price;
	}
}