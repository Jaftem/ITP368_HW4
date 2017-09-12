import java.util.*;

import javax.management.modelmbean.ModelMBean;

public class IceCreamShop {
    //private static final String MENU_FILENAME = "../menu.txt"; //currently configured to run from bin folder
    //private Menu menu;
    private ShopUI shopUI;
    private Map<String, Order> orderHistory;
    public IceCreamShop() {
        //menu = new Menu(MENU_FILENAME);
        shopUI = new ConsoleShopUI();
        orderHistory = new HashMap<>();
        shopUI.displayMessage("Welcome to Ice Cream Shop!");
    }

    public static void main(String[] args) {
        IceCreamShop ics = new IceCreamShop();
        ics.askForAction();
    }
    public void askForAction() {
        boolean shopClosed = false;
        while(!shopClosed) {
            boolean customerDone = false;            
            String currentCustomer = shopUI.promptUserForString("Hi, could I get your name for your order please?");
            Order order = new Order();
            while(!customerDone) {
                shopUI.displayMenu(ShopActions.getMenu());
                int actionID = shopUI.promptUserForInteger("Please input a number from the menu.");
                switch(ShopActions.values()[actionID-1]) {
                    case BUY:
                        order.addItem(askForItem());
                        break;
                    case VIEW:
                        viewOrder(order);
                        break;
                    case CANCEL:
                        shopUI.displayMessage("Your order has been cancelled. See you next time!");
                        customerDone = true;
                        break;
                    case PAY:
                        viewOrder(order);
                        shopUI.displayMessage("Thanks for shopping with us!");                        
                        customerDone = true;
                        break;
                }
            }
            //customer has finished ordering, put in history
            orderHistory.put(currentCustomer, order);     
            shopClosed = !continueSelling(); //if want to continue, dont close shop    
        }
        closeShop();
    }

    public Item askForItem() {
        String prompt = "Please choose an item from the following list: \n" +
                        "1. Ice Cream \n" +
                        "2. Gelato \n";
        int itemType = shopUI.promptUserForInteger(prompt);
        Item i = null;
        if (itemType == 1) {
            i = askForIceCream();
        } 
        else {
            i = askForGelato();
        }
        return i;
    }

    public IceCream askForIceCream() {
        Size size = askForEnumOption(Size.class);
        Container container = askForEnumOption(Container.class);
        List<Type> types = askForTypes();
        TraditionalFlavor flavor = askForEnumOption(TraditionalFlavor.class);
        return new IceCream(size, container, types, flavor);
    }

    public Gelato askForGelato() {
        Size size = askForEnumOption(Size.class);
        Container container = askForEnumOption(Container.class);
        List<Type> types = askForTypes();
        boolean hasLowButterfat = shopUI.promptUserForBoolean("Do you want low butter fat?");
        boolean isItalianImported = shopUI.promptUserForBoolean("Do you want our special Italian imported mix?");
        FruitFlavor flavor = askForEnumOption(FruitFlavor.class);
        return new Gelato(size, container, types, hasLowButterfat, isItalianImported, flavor);     
    }

    public void viewOrder(Order order) {
        shopUI.displayMessage("Your order looks like this:");
        shopUI.displayMessage(order.toString());
    }

    public void closeShop() {
        shopUI.displayMessage("The shop is now closed!");
        shopUI.displayMessage("Here are all the transactions made today!");
        shopUI.displayMessage(prettyOrderHistoryString());       
    }

    public boolean continueSelling() {
        return shopUI.promptUserForBoolean("Shall we take another customer today?");
    }

    private String prettyOrderHistoryString() {
        String str = "";
        for(Map.Entry<String, Order> entry : orderHistory.entrySet()) {
            String shopper = entry.getKey();
            Order order = entry.getValue();
            if(order.getSize() == 0) {
                str += "Shopper " + shopper + " didn't get anything!\n";
            }
            else {
                str += "Shopper " + shopper + " bought: \n";
                str += order.toString();
            }
            str += "----------------------\n"; //separate each shopper
        }
        return str;
    }

    public <E extends Enum<E>> E askForEnumOption(Class<E> enumType) {
        boolean done = false;
        E option = null;
        while(!done) {
            shopUI.displayMessage("********************");
            for (E val : enumType.getEnumConstants()){
                shopUI.displayMessage(val.name().toLowerCase().replace("_", " "));
            }
            String input = shopUI.promptUserForString("Please select a " + enumType.getName() + " from the list above!");
            try {
                option = Enum.valueOf(enumType, input.toUpperCase().replace(' ', '_'));
                done = true;
            }
            catch(Exception e) {
                shopUI.displayMessage("Option not recognized. Please try again. \n");
            }
        }
        return option;
    }

    public List<Type> askForTypes() {
        List<Type> types = new LinkedList<Type>();
        String prompt = "Please specify what kind of ice cream you would like \n" +
                        "1. Sugar Free \n" +
                        "2. Fat Free \n" +
                        "3. Half and Half \n" +
                        "(ex. Type '13' for Sugar-free, half and half, or '123' for all options";
        boolean done = false;
        while(!done) {
            done = true;
            String input = shopUI.promptUserForString(prompt);
            for(char typeChar : input.toCharArray()) {
                if (typeChar == '1') 
                    types.add(Type.SUGAR_FREE);
                else if (typeChar == '2')
                    types.add(Type.FAT_FREE);
                else if (typeChar == '3')
                    types.add(Type.HALF_AND_HALF);
                else {
                    done = false;
                    shopUI.displayMessage("Unable to parse your answer. Please try again.");
                } 

            }
        }
        return types;
    }
}