// Jeremy Aftem
// ITP 368
// HW 04
// aftem@usc.edu

import java.util.ArrayList;
import java.util.List;

public abstract class Item {
	protected double price;
	
	protected Size size;
	protected List<Type> types;
	protected List<Topping> toppings;
	
	// Constructor
	public Item() {
		toppings = new ArrayList<Topping>();
	}
	
	public Item(Size size, List<Type> types) {
		this.size = size;
		this.types = types;
	}
	
	public Item(double price) {
		this.price = price;
	}
	
	// Getters
	public Size getSize() {
		return size;
	}
	public List<Type> getTypes() {
		return types;
	}

	// Abstract Methods
	public abstract double getPrice();
}
