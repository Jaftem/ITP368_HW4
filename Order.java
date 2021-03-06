import java.util.List;
import java.util.LinkedList;
public class Order {
    private List<Item> items;

    public Order() {
        items = new LinkedList<Item>();
    }

    public void addItem(Item i) {
        items.add(i);
    }

    public double calculatePrice() {
        double sum = 0;
        for(Item i : items) {
            sum += i.getPrice();
        }
        return sum;
    }

    public int getSize() {
        return items.size();
    }

    public String toString() {
        String str = "";
        for(Item i : items) {
            str += i.toString() + String.format(" for $%.2f", i.getPrice()) + "\n";
        }
        str += String.format("Total: $%.2f", calculatePrice()) + "\n";
        return str;
    }
}