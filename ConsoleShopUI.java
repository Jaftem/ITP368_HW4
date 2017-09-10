import java.util.Scanner;
public class ConsoleShopUI implements ShopUI {
    private Scanner sc;

    public ConsoleShopUI() {
        sc = new Scanner(System.in);
    }

    @Override
    public boolean promptUserForBoolean(String prompt) {
        boolean isBoolean = false;
        while(!isBoolean){
            String input = grabInput(prompt);
            if(input.startsWith("y") || input.startsWith("Y")){
                return true;
            }
            else if(input.startsWith("n") || input.startsWith("N")){
                return false;
            }
            else{
                System.out.println("System could not parse a boolean. Please use (Y/y/N/n).");
            }
        }
        return false; //unreachable    
    }

    @Override
    public int promptUserForInteger(String prompt) {
        boolean validInt = false;
        int input = 0;        
        while(!validInt) {
            try {
                input = Integer.parseInt(grabInput(prompt));
                validInt = true;
            }
            catch (NumberFormatException nfe) {
                System.out.println("System could not recognize an integer. Please enter a valid integer.");
                validInt = false;
            }
        }
        return input;
    }

    @Override
    public String promptUserForString(String prompt) {
        return grabInput(prompt);
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    private String grabInput(String prompt) {
        System.out.println(prompt);
        return sc.nextLine();
    }
}