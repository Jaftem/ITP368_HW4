import java.util.List;

public class IceCream extends Item {
	protected int madeIceCream = 0;
	TraditionalFlavor flavor;
	
	public IceCream() {
		super();
	}
	
	public IceCream(Size size, Container container, List<Type> types, TraditionalFlavor flavor) {
		super(size, types, container);
		this.flavor = flavor;
	}

	// Getters
	@Override
	public double getPrice() {
		return super.getPrice();
	}
	
	public int getMadeIceCream() {
		return madeIceCream;
	}
	
	// Setters
	public void setFlavor(TraditionalFlavor flavor) {
		this.flavor = flavor;
	}
	
	// TODO: 
	public String toString() {
		return "Ice Cream " + size.name() + " " + container.name() + " " + types.toString() + " " + flavor.name();
	}

}
