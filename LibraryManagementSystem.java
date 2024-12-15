
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {

    ArrayList<Item> listOfItems = new ArrayList<Item>();

    public void addItem(Item item) {
        listOfItems.add(item);

    }

    private void setBorrowedReturned(Item item, boolean flag) {
        for (int i = 0; i < listOfItems.size(); i++) {
            Item itemName = listOfItems.get(i);
            if (itemName.getName().equalsIgnoreCase(item.getName())) {
                itemName.setBorrowed(flag);
            }
        }
    }

    public void returnBorrowedItem(Item item) {
        setBorrowedReturned(item, true);
        System.out.println(item.getName() + " has been returned to the Library.");
    }

    public void borrowItem(Item item) {
        setBorrowedReturned(item, false);
        System.out.println(item.getName() + " has been borrowed from the Library.");
    }

    public void buyItem(Item item) {
        for (int i = 0; i < listOfItems.size(); i++) {
            Item itemName = listOfItems.get(i);
            if (itemName.getName().equalsIgnoreCase(item.getName())) {
                if (item.getSold() == false) {
                    itemName.setSold(true);
                    System.out.println(
                            item.getName() + " has been bought and money has been taken away from your account.");

                } else {
                    System.out.println(item.getName() + " has been already sold");
                }
            }
        }

    }

    public void printList() {
        for (int i = 0; i < listOfItems.size(); i++) {
            System.out.println("Name: " + listOfItems.get(i).getName() + " type: " + listOfItems.get(i).getType()
                    + " Availability: " + listOfItems.get(i).getBorrowed() + " Bought: "
                    + listOfItems.get(i).getSold());
        }

    }

    public void createItems() {
        Item book1 = new Book("Harry Potter");
        this.addItem(book1);
        Item book2 = new Book("The Martian");
        this.addItem(book2);
        Item book3 = new Book("Percy Jackson");
        this.addItem(book3);
        Item newspaper1 = new Newspaper("New York Times", 1.50);
        this.addItem(newspaper1);
        Item newspaper2 = new Newspaper("Los Angeles Times", 2.00);
        this.addItem(newspaper2);
        Item newspaper3 = new Newspaper("San Francisco Chronicle", 5.00);
        this.addItem(newspaper3);
        Item magazine1 = new Magazine("National Geographic", 2.00);
        this.addItem(magazine1);
        Item magazine2 = new Magazine("Us Weekly", 1.00);
        this.addItem(magazine2);
        Item magazine3 = new Magazine("Vogue", 4.00);
        this.addItem(magazine3);
        Item dvd1 = new Dvd("Finding Nemo", 7.00);
        this.addItem(dvd1);
        Item dvd2 = new Dvd("Spider-Man", 5.70);
        this.addItem(dvd2);
        Item dvd3 = new Dvd("Shrek", 10.99);
        this.addItem(dvd3);

    }

    public static void main(String[] args) {
        LibraryManagementSystem lms = new LibraryManagementSystem();
        lms.createItems();
        boolean run = true;
        while (run) {
            lms.printList();
            Scanner scanner = new Scanner(System.in);
            Scanner scanner1 = new Scanner(System.in);
            Scanner scanner2 = new Scanner(System.in);

            System.out.println(
                    "What would you like to do? 0 for Donate, 1 for Borrow, 2 for Return, or 3 for Buy an Item (BOOKS CANNOT BE BOUGHT)?");
            int options = scanner.nextInt();

            System.out.println(
                    "What type of item would you like to do it for, 0 for book, 1 for Newspaper, 2 for magazine, 3 for DVD");
            int type = scanner.nextInt();

            System.out.println("What is the Item's name");
            String itemName = scanner1.nextLine();

            double price = -0;
            if ((options == 0) && (type != 0)) {
                System.out.println("What is the price of the item?");
                price = scanner2.nextDouble();
            }

            Item item = null;
            if (type == 0) {
                item = new Book(itemName);
            } else if (type == 1) {
                item = new Newspaper(itemName, price);
            } else if (type == 2) {
                item = new Magazine(itemName, price);
            } else if (type == 3) {
                item = new Dvd(itemName, price);
            }

            if (options == 0) {
                lms.addItem(item);
                lms.printList();
            } else if (options == 1) {
                lms.borrowItem(item);
                lms.printList();
            } else if (options == 2) {
                lms.returnBorrowedItem(item);
                lms.printList();
            } else if (options == 3) {
                lms.buyItem(item);
                lms.printList();

            }
            System.out.println("Do you want to exit? Yes or No?");
            String exit = scanner1.nextLine();
            if (exit.equalsIgnoreCase("yes")) {
                run = false;
            }
        }

    }

}
