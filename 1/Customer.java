import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Customer {
  Scanner input = new Scanner(System.in);
  Database db = new Database();

  public Customer() {}

  public void cusNavi(){
    System.out.println("\nWhat do you want to do?\n");

    System.out.println("a Foodeliver Menu");
		System.out.println("b Order Status");
		System.out.println("c Order History\n");

    System.out.print("Selection (a/b/c): ");
		String selectionC = input.next();

		switch (selectionC) {
			case "a":
				cusNaviA();
        break;
      case "b":
      //case "b":
        //cusNaviB();
      //case "c":
        //cusNaviC();
      default:
        System.out.println("Thank you!");
    }
  }

  public void cusNaviA() {
    try {
      System.out.println("\n\tFOODELIVER MENU\n");
      System.out.println("CODE NAME PRICE\n");
      db.readFoodeliverMenuFromFile();
      System.out.println("");
    } catch (IOException e) {
        System.out.println("Failed");
      }
    System.out.println("Choice of food (Insert code of dish selection): ");
  }
}
