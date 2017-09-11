public enum ShopActions {
	BUY("Order Something"),
	VIEW("View order"),
	CANCEL("Cancel current order"),
    PAY("Finish order and pay"),
    QUIT("Close the shop for the day (quit program)");

	private String description;
	private ShopActions(String description){
		this.description = description;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	

	public static String getMenu(){
		String menu = "\n***** MENU *****";
	
		for(ShopActions m : ShopActions.values()){
			menu += "\n" + (m.ordinal() + 1) + ": " + m.getDescription();
			
		}
		menu+="\n**********************************************\n";
		return menu;
	}
}
