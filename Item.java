
public class Item {

    private String name;
    private int type;
    private double price;
    private boolean borrowed = true;
    private boolean sold = false;

    public Item(String itemName, int itemType, double itemPrice) {
        name = itemName;
        type = itemType;
        price = itemPrice;
    }

    public void setName(String itemName) {
        name = itemName;
    }

    public void setType(int itemType) {
        type = itemType;
    }

    public void setPrice(double itemPrice) {
        price = itemPrice;
    }

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrow) {
        borrowed = borrow;
    }

    public boolean getSold() {
        return sold;
    }

    public void setSold(boolean soldItem) {
        sold = soldItem;
    }

}