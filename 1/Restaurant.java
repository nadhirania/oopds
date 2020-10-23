import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Restaurant {
  Scanner input = new Scanner(System.in);
  Database db = new Database();

  public Restaurant() {}

  public void resNavi() throws IOException {
    System.out.println("\nWhat do you want to do?\n");

    System.out.println("a Update Foodeliver Menu");
		System.out.println("b Order Status");
		System.out.println("c Order History\n");

    System.out.print("Selection (a/b/c): ");
    String selectionR = input.next();

    switch(selectionR) {
      case "a":
        resNaviA();
        break;
      //case "b":
      //resNaviB();
      //case "c":
      //resNaviC();
      default:
        System.out.println("Thank you!");
    }
  }

  public void resNaviA() throws IOException {
    System.out.println("\nCODE NAME PRICE\n");
    db.readFoodeliverMenuFromFile();
    System.out.println("\nUpdate Foodeliver Menu");
  	System.out.println("1 Add / 2 Update / 3 Delete");
  	System.out.print("Selection: ");
  	int selectionU = input.nextInt();

    if(selectionU == 1) {
      System.out.println("\nAdd dish to restaurant menu\n");
      addMenu();
    }else if(selectionU == 2) {
      System.out.println("\nUpdate dish on menu");
    }else if(selectionU == 3) {
      System.out.println("Remove dish from menu");
    }
  }

  public void addMenu() {
    try {
      System.out.println("CODE NAME PRICE\n");
      ArrayList<FoodeliverMenu> menu = db.readFoodeliverMenuFromFile();
      System.out.print("\nDish code: ");
      int code = input.nextInt();

      System.out.print("Dish name: ");
      String name = input.nextLine(); // read away unwanted newline.
      name = input.nextLine();        // read user input.

      System.out.print("Dish price: ");
      double price = input.nextDouble();

      menu.add(new FoodeliverMenu(code, name, price));

      System.out.println("\nNOTE: Dish added to your menu.\n");
      db.saveFoodeliverMenuToFile(menu);
      db.readFoodeliverMenuFromFile();
      resNavi();
    } catch (IOException e) {
        System.out.println("Failed");
      }
  }
}
