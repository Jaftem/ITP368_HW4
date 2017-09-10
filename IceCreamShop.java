import java.util.*;

import javax.management.modelmbean.ModelMBean;

public class IceCreamShop {
    private static final String MENU_FILENAME = "../menu.txt"; //currently configured to run from bin folder
    private Menu menu;
    private ShopUI shopUI;
    public IceCreamShop() {
        menu = new Menu(MENU_FILENAME);
        shopUI = new ConsoleShopUI();
        shopUI.displayMessage("Welcome to Ice Cream Shop!");
    }

    public static void main(String[] args) {
        IceCreamShop ics = new IceCreamShop();
        ics.askForAction();
    }
    public void askForAction() {
        boolean done = false;
        while(!done) {
            shopUI.displayMenu(ShopActions.getMenu());
            int actionID = shopUI.promptUserForInteger("Please input a number from the menu.");
            switch(ShopActions.values()[actionID-1]) {
                case ICECREAM:
                    System.out.println("buy icecream");
                    break;
                case VIEW:
                    System.out.println("viewing order");
                    break;
                case CANCEL:
                    System.out.println("cacnelling order");
                    break;
                case PAY:
                    System.out.println("paying");
                    break;
                case QUIT:
                    System.out.println("bye");
                    done = true;
                    break;
            }
        }

    }
}