/*import java.util.ArrayList;
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

    @Override
    public String toString() {
        return  name  + "," + serialNumber + "," + value;
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
                    for (Inventory item : items) {
                        System.out.println(item);
                    }
                    break;
                case 5:
                    break;
                default:
                    break;
            }
        } while (choice != 5);

        in.close();
    }
}*/
import java.util.Scanner;
import java.util.ArrayList;

class Inventory {
  String name;
  String serialNumber;
  double value;

  public void Initializer(String name_arg, String SN_arg, double price){
    name = name_arg;
    serialNumber = SN_arg;
    value = price;
  }
  public void Print(){
    System.out.println(name + "," + serialNumber + "," +  value);
  }
  public String getSN(){
    return serialNumber;
  }
}

class Main {
	public static void main(String[] args) {
  Scanner in = new Scanner(System.in);
  ArrayList<Inventory> myInventory = new ArrayList<>();
  int selection;
    
  do{
    System.out.println("\nPress 1 to add an item");
    System.out.println("Press 2 to delete an item");
    System.out.println("Press 3 to update an item");
    System.out.println("Press 4 to show all the items");
    System.out.println("Press 5 to exit the program");
    selection = in.nextInt();
    in.nextLine();
    String name, serialNumber;
    int price;
    Inventory myItem = new Inventory();
    
    switch(selection){
      case 1:
        System.out.println("Enter the name: ");
        name = in.nextLine();
        System.out.println("Enter the serial number: ");
        serialNumber = in.nextLine();
        System.out.println("Enter the value in dollars (whole number): ");
        price = in.nextInt();

        myItem.Initializer(name, serialNumber, price);
        myInventory.add(myItem);
        break;
        
      case 2:
        System.out.println("Enter the serial number of the item to delete: ");
        serialNumber = in.nextLine();
        for (Inventory element : myInventory){
          if(serialNumber.equals(element.getSN())){
            myInventory.remove(myInventory.indexOf(element));
            break;
          }
        }
        break;
        
      case 3:
        System.out.println("Enter the serial number of the item to change: ");
        serialNumber = in.nextLine();
        for (Inventory element : myInventory){
          if(serialNumber.equals(element.getSN())){
            serialNumber = element.getSN();
            System.out.println("Enter the new name: ");
            name = in.nextLine();
            
            System.out.println("Enter the new value in dollars (whole number): ");
            price = in.nextInt();

            myItem.Initializer(name, serialNumber, price);
            myInventory.set(myInventory.indexOf(element), myItem);
            break;
          }
        }  
        break;
        
      case 4:
        for (Inventory element : myInventory) {
          element.Print();
        }
        break;

      case 5:
        break;
  
      default:
        System.out.println("INVALID INPUT");
        break;
        
        
        
    }
  }while(selection != 5);


	}
}