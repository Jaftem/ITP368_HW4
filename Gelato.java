import java.util.List;

public class Gelato extends Item {
	protected final static double GELATO_BASE_PRICE    = 1.50;
	protected final static double LOW_BUTTERFAT_PRICE  =  .25;
	protected final static double ITALIAN_PRICE        = 1.00;
	// in the US butterfat of ice cream must be 10%. Gelato butterfat = 3.5% or greater
	boolean hasLowButterfat;
	boolean isItalianImported;
	
	FruitFlavor flavor;

	public Gelato() {
		super();
		price += GELATO_BASE_PRICE;
	}
	
	public Gelato(boolean hasLowButterfat, boolean isItalianImported, FruitFlavor flavor) {
		super();
		this.hasLowButterfat = hasLowButterfat;
		this.isItalianImported = isItalianImported;
		this.flavor = flavor;
	}
	
	public Gelato(Size size, List<Type> types, boolean hasLowButterfat, boolean isItalianImported, FruitFlavor flavor) {
		super(size, types);
		this.hasLowButterfat = hasLowButterfat;
		this.isItalianImported = isItalianImported;
		this.flavor = flavor;
	}
	
	@Override
	public double getPrice() {
		double runningPrice = 0;
		runningPrice += hasLowButterfat ? super.getPrice() : super.getPrice() + LOW_BUTTERFAT_PRICE;
		runningPrice += isItalianImported ? ITALIAN_PRICE : 0;
		return runningPrice;
	}
	
	public double getBasePrice() {
		return GELATO_	BASE_PRICE;
	}
	
	public double getButterfatPrice() {
		return LOW_BUTTERFAT_PRICE;
	}
	
	public double getItalianImportedPrice() {
		return ITALIAN_PRICE;
	}

	// TODO:
	public String toString() {
		return "";
	}
}
