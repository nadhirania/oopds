import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Restaurant {
  Scanner input = new Scanner(System.in);
  Database db = new Database();
  boolean uexit = true;

  public Restaurant() {}

  public void resNavi() throws IOException {
    System.out.println("\nWhat do you want to do?\n");

    System.out.println("\na Update Foodeliver Menu");
		System.out.println("b Order Status"); //Preparing, Ready, Delivering, Collected
		System.out.println("c Order History");
    System.out.println("d Exit\n");

    do {

      System.out.print("Selection (a/b/c/d): ");
      String selectionR = input.next();

      switch(selectionR) {
        case "a":
          resNaviA();
          break;
        case "b":
          resNaviB();
          break;
        //case "c":
        //resNaviC();
        default:
          System.out.println("Thank you!");
          return;
      }

      System.out.println("\nPress 0 to exit. Press anything to continue ");
      int x = input.nextInt();
      if (x == 0) {
      	uexit = false;
      }
    } while (uexit);
  }

  public void resNaviA() throws IOException {
    System.out.println("\nCODE NAME PRICE\n");
    ArrayList<FoodeliverMenu> menu = db.readFoodeliverMenuFromFile();
    db.printFoodeliverMenuFromFile(menu);
    System.out.println("\nUpdate Foodeliver Menu");
  	System.out.println("1 Add / 2 Update / 3 Delete");
  	System.out.print("Selection: ");
  	int selectionU = input.nextInt();

    if(selectionU == 1) {
      System.out.println("\nAdd dish to restaurant menu\n");
      addMenu();
    }else if(selectionU == 2) {
      System.out.println("\nUpdate dish on menu");
      editMenu();
    }else if(selectionU == 3) {
      System.out.println("\nRemove dish from menu");
      deleteMenu();
    }
  }

  public void addMenu() {
    try {
      System.out.println("CODE NAME PRICE\n");
      ArrayList<FoodeliverMenu> menu = db.readFoodeliverMenuFromFile();
      db.printFoodeliverMenuFromFile(menu);
      System.out.print("\nDish code: ");
      int code = input.nextInt();

      System.out.print("Dish name: ");
      String name = input.nextLine(); // read away unwanted newline.
      name = input.nextLine();        // read user input.

      System.out.print("Dish price: ");
      double price = input.nextDouble();

      menu.add(new FoodeliverMenu(code, name, price));

      System.out.println(menu.get(code-1));
      System.out.println("\nNOTE: Dish added to your menu.\n");
      db.saveFoodeliverMenuToFile(menu);
      System.out.println("-----------------------------------------------");
      db.readFoodeliverMenuFromFile();
      //resNavi();
    } catch (IOException e) {
        System.out.println("Failed");
      }
  }

  public void editMenu() {
    try {
      ArrayList<FoodeliverMenu> menu = db.readFoodeliverMenuFromFile();
      db.printFoodeliverMenuFromFile(menu);
      //db.readFoodeliverMenuFromFile();
      System.out.print("\nDish code: ");
      int code = input.nextInt();
      System.out.print("\nEnter new dish name: ");
      String tempName = input.next();
      System.out.print("Enter new dish price: ");
      double tempPrice = input.nextDouble();

      //System.out.println(menu.get(0).toCodeString()); //this check the get function
      if (code == menu.get(code - 1).getCode()) {
        //System.out.println(menu.get(code - 1)); to check the list items
        menu.get(code - 1).setName(tempName);
        menu.get(code - 1).setPrice(tempPrice);

        System.out.println(menu.get(code - 1));

        db.saveFoodeliverMenuToFile(menu);
        System.out.println("\nNOTE: Dish updated on your menu.\n");
        System.out.println("-----------------------------------------------");
        //resNavi();
      } else {
          System.out.println("Try again!");
        }
    } catch (IOException e) {
        System.out.println("Failed");
      }
  }

  public void deleteMenu() {
    try {
      ArrayList<FoodeliverMenu> menu = db.readFoodeliverMenuFromFile();
      db.printFoodeliverMenuFromFile(menu);
      System.out.print("\nDish code: ");
      int code = input.nextInt();

      if (code == menu.get(code - 1).getCode()) {

        menu.remove(menu.get(code - 1));
        System.out.println("\nNOTE: Dish deleted from your menu.\n");

        db.saveFoodeliverMenuToFile(menu);
        System.out.println("-----------------------------------------------");
        //resNavi();

      } else {
        System.out.println("Try again!");
      }
    } catch (IOException e) {
        System.out.println("Failed");
      }
  }

  public void resNaviB() throws IOException {
    System.out.println("\nORDER STATUS");
    System.out.println("a View Customer");
    System.out.println("b Update Status\n");

    System.out.print("\nSelection(a/b): ");
    String selectionS = input.next();

    switch(selectionS) {
      case "a":
        System.out.println("View Customer Status");
        viewOrder();
        break;
      case "b":
        System.out.println("Update Status\n");
        System.out.println("1 Preparing | 2 Ready | 3 Delivering | 4 Collected");
        editOrder();
        break;
      default:
        System.out.println("Thank you!");
        return;
    }
  }

  public void viewOrder() throws IOException {
    //we want to view the status from the restaurant pov
    //just basically access the OrderDB and print it. (use the getStatus)
    ArrayList<Order> OrderList = db.readOrderFromFile();
    ArrayList<Order> OrderDB = db.OrderDatabase(OrderList);
    System.out.print("\n");
    for (int i = 0; i < OrderDB.size(); i++ ) {
      System.out.println("\nOrder List; " + " Order ID: " + OrderDB.get(i).getOrderID() + ", Name:"  + OrderDB.get(i).getFm() + ", Status:" + OrderDB.get(i).getStatus());
    }
  }

  public void editOrder() throws IOException {
    //access the OrderDB, from order. change the status by using setStatus
    ArrayList<Order> OrderList = db.readOrderFromFile();
    ArrayList<Order> OrderDB = db.OrderDatabase(OrderList);
    System.out.print("\n");
    for (int i = 0; i < OrderDB.size(); i++ ) {
      System.out.println("OrderID: " + OrderDB.get(i).getOrderID() + ", Name: "  + OrderDB.get(i).getFm() + ", Status:" + OrderDB.get(i).getStatus());
    }
    System.out.print("\nOrder ID: ");
    int tempUserID = input.nextInt(); //input 4
    //int tempODBSize = OrderDB.size()-1;
    //System.out.print("\ntempODBSize= " + tempODBSize + " ");

    if (tempUserID == ArrayListOrderFinder(tempUserID)){
      System.out.print("Update Status: ");
      int tempStatus = input.nextInt();
      OrderDB.get(tempUserID).setStatus(tempStatus);
      db.saveOrderToFile(OrderList);
      System.out.println("\nUpdated Status: \n");
      for (int i = 0; i < OrderDB.size(); i++ ) {
        System.out.println("OrderID: " + OrderDB.get(i).getOrderID() + ", Name: "  + OrderDB.get(i).getFm() + ", Status:" + OrderDB.get(i).getStatus());
      }
    } else {
        System.out.println("Error!");
      }
  }

  public void resNaviC() throws IOException {

  }

  public int ArrayListOrderFinder(int theIDofOrder) throws IOException {
    ArrayList<Order> OrderList = db.readOrderFromFile();
    ArrayList<Order> OrderDB = db.OrderDatabase(OrderList);
    int length = OrderDB.size();
    int i = 0;

    while ( i <= length){

      if (OrderDB.get(i).getOrderID() == theIDofOrder){
        return theIDofOrder;
      }
      else{
          i = i + 1;
      }
    }
    return -1;
  }
}//end of restaurant
