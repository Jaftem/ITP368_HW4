public interface ShopUI {
    public String promptUserForString(String prompt);
    public int promptUserForInteger(String prompt);
    public boolean promptUserForBoolean(String prompt);
    public void displayMessage(String message);
    public void displayMenu(String menu);
}