import java.util.List;

public class IceCream extends Item {
	TraditionalFlavor flavor;
	
	public IceCream() {
		super();
	}
	
	public IceCream(Size size, List<Type> types, TraditionalFlavor flavor) {
		super(size, types);
		this.flavor = flavor;
	}
	
	@Override
	public double getPrice() {
		return super.getPrice();
	}
	

	// TODO: 
	public String toString() {
		return "";
	}
}
