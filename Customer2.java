import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Customer2 {
  Scanner input = new Scanner(System.in);
  Database db = new Database();
  boolean uexit = true;

  public Customer2() {}

  public void cusNavi(){
    do {
      System.out.println("\nWhat do you want to do?\n");

      System.out.println("a Foodeliver Menu");
  		System.out.println("b Order Status");
  		System.out.println("c Order History");
      System.out.println("d Exit\n");

      System.out.print("Selection (a/b/c/d): ");
  		String selectionC = input.next();

      switch (selectionC) {
  			case "a":
  				cusNaviA();
          break;
        case "b":
          cusNaviB();
          break;
        //case "c":
          //cusNaviC();
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

  public void cusNaviA() { //FOODELIVER MENU
    try {
      System.out.println("\n\tFOODELIVER MENU\n");
      System.out.println("CODE NAME PRICE\n");
      ArrayList<FoodeliverMenu> menu = db.readFoodeliverMenuFromFile();
      ArrayList<Order> OrderList = db.readOrderFromFile();
      ArrayList<Order> OrderDB = db.OrderDatabase(OrderList);

      db.printFoodeliverMenuFromFile(menu);
      //db.readFoodeliverMenuFromFile();
      System.out.println("");
      System.out.print("Choice of food (Insert code of dish selection): ");
      int code = input.nextInt();
      // compare the input with db, if exist. add name to od.
      if (code == menu.get(code - 1).getCode()) {
        // add the menu in od

        setMenu(OrderDB.size(),code);


      } else {
          System.out.println("Try again!");
      }
    } catch (IOException e) {
        System.out.println("Failed");
      }
  }

  public void setMenu(int i, int n) throws IOException{
    ArrayList<Order> OrderList = db.readOrderFromFile();
    ArrayList<Order> OrderDB = db.OrderDatabase(OrderList);
    ArrayList<FoodeliverMenu> menu = db.readFoodeliverMenuFromFile();
    //we need to get the name of the food and the ID of the Foodeliver
    System.out.print("\n");
    OrderList.add (new Order());
    OrderDB.get(i).setFm(menu.get(n-1).getName());
    db.saveOrderToFile(OrderList);
    System.out.println("\nThis is your order: " + " OrderID: " + OrderDB.get(i).getOrderID() + ", Food:"  + OrderDB.get(i).getFm());

    //for (int j = 0; j <= i; j++ ) {
      //OrderDB.get(i).setFm(menu.get(n-1).getName());
      //System.out.println(OrderDB.toString());
    //}
  }
    //db.printOrderDatabase(OrderDB);

  public void cusNaviB() { //Order Status
    try {
      //we want to view the status from the restaurant pov
      //just basically access the OrderDB and print it. (use the getStatus)
      ArrayList<Order> OrderList = db.readOrderFromFile();
      ArrayList<Order> OrderDB = db.OrderDatabase(OrderList);
      System.out.print("\n");
      for (int i = 0; i < OrderDB.size(); i++ ) {
        System.out.println("\nOrder List; " + " Order ID: " + OrderDB.get(i).getOrderID() + ", Name:"  + OrderDB.get(i).getFm() + ", Status:" + OrderDB.get(i).getStatus());
      }
    } catch (IOException e) {
        System.out.println("Failed");
      }
  }

  public void cusNaviC() {

  }
}
