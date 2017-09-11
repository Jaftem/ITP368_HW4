import java.util.List;

public class IceCream extends Item {
	protected int madeIceCream = 0;
	TraditionalFlavor flavor;
	
	public IceCream() {
		super();
	}
	
	public IceCream(Size size, List<Type> types, TraditionalFlavor flavor) {
		super(size, types);
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
		return "";
	}
	
	public IceCream make(Size size, List<Type> types, TraditionalFlavor flavor) {
		madeIceCream++;
		return new IceCream(size, types, flavor);
	}
}
