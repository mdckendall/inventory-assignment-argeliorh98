import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Inventory {
    String name;
    String serialNumber;
    int value;
    
    public Inventory(String name, String serialNumber, int value) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.value = value;
    }
}

class Menu {
    public static void main(String[] args) {
        ArrayList<Inventory> items = new ArrayList<Inventory>();
        Scanner in = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("Press 1 to add an item.");
            System.out.println("Press 2 to delete an item.");
            System.out.println("Press 3 to update an item.");
            System.out.println("Press 4 to show all the items.");
            System.out.println("Press 5 to quit the program.");
            choice = in.nextInt();
            in.nextLine(); // Consume newline character
            
            switch (choice) {
                case 1:
                    System.out.println("Enter the name:");
                    String name = in.nextLine();
                    System.out.println("Enter the serial number:");
                    String serialNumber = in.nextLine();
                    System.out.println("Enter the value in dollars (whole number):");
                    int value = in.nextInt();
                    in.nextLine(); // Consume newline character
                    Inventory inv = new Inventory(name, serialNumber, value);
                    items.add(inv);
                    break;
                case 2:
                    System.out.println("Enter the serial number of the item to delete:");
                    String serialN = in.nextLine();
                    for (Inventory item : items) {
                        if (item.serialNumber.equals(serialN)) {
                            items.remove(item);
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter the serial number of the item to change:");
                    String serialNum = in.nextLine();
                    System.out.println("Enter the new name:");
                    String newName = in.nextLine();
                    System.out.println("Enter the new value in dollars (whole number):");
                    int newValue = in.nextInt();
                    in.nextLine(); // Consume newline character
                    for (Inventory item : items) {
                        if (item.serialNumber.equals(serialNum)) {
                            item.name = newName;
                            item.value = newValue;
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println(Arrays.deepToString(items.toArray()));
                    break;
                case 5:
                    System.out.println();
                    break;
                default:
                    System.out.println();
                    break;
            }
        } while (choice != 5);
        
        in.close();
    }
}
