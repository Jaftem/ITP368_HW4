// Jeremy Aftem
// ITP 368
// HW 04
// aftem@usc.edu

import java.util.ArrayList;
import java.util.List;

public abstract class Item {
	protected double price = 0;
	protected Size size;
	protected List<Type> types;
	protected List<Topping> toppings;
	protected Container container;
	
	// Constructor
	public Item() {
	}
	
	public Item(Size size, List<Type> types, Container container) {
		this.size = size;
		this.types = types;
		this.container = container;
		toppings = new ArrayList<Topping>();		
	}
	
	// Getters
	public Size getSize() {
		return size;
	}
	public List<Type> getTypes() {
		return types;
	}

	// Setters
	public void addTopping(Topping topping) {
		toppings.add(topping);
	}
	public void addType(Type type) {
		types.add(type);
	}
	
	public double getPrice() {
		double runningPrice = 0;
		for (Type t : types) {
			runningPrice += t.getPrice();
		}
		runningPrice += toppings.size() * Topping.PRICE_PER_TOPPING;
		runningPrice += size.getPrice();
		runningPrice += container.getPrice();//wow this looks really expensive
		return runningPrice;
	}

	// Abstract methods
	public abstract String toString();
}
