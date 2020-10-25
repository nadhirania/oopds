import java.io.IOException;
import java.util.Scanner;
import java.util.*;
import java.io.File;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) throws IOException {
    VerifyLogin login = new VerifyLogin();
    Database db = new Database();
    Restaurant res = new Restaurant();
    Customer2 cus = new Customer2();
    Scanner input = new Scanner(System.in);
    boolean uexit = true;

    do {

      System.out.println("\n\tWELCOME TO FOODELIVER");
      ArrayList<User> UserList = db.readCustomerDatabaseFromFile();
      //System.out.print(UserList);

  		System.out.println("\nChoose Role: ");
  		System.out.println("1 Customer");
  		System.out.println("2 Restaurant");
  		System.out.print("> ");
  		int r = input.nextInt();
  		if (r > 3) {
  			System.out.println("Invalid input!");
  			return;
  		}

  		if (r == 1) { // CUSTOMER
  			System.out.println("\n\t-> CUSTOMER <-\n");

        System.out.print("Username[Case sensitive!]: ");
        String username = input.next();
        System.out.print("Password[Case sensitive!]: ");
        String password = input.next();
        String filepath = "User.csv";


        login.VerifyLogin(username, password, filepath);

        //int SessionID = findUser(UserList, User@42a57993);
        // int SessionID = UserList.get().getUserID();
        //System.out.println("SessionID");



        cus.cusNavi();

      }else if (r == 2) { //RESTAURANT
        System.out.println("\n\t-> RESTAURANT <-\n");
  			System.out.println("List of Restaurant:");
  			System.out.println("1 Burger Queen Restaurant");
  			System.out.println("2 Mak Kiah Restaurant");
  			System.out.println("3 Pasta Box Restaurant");
  			System.out.print("\nSelect your restaurant: ");
  			int t = input.nextInt();

  			if (t > 3) {
  				System.out.println("Invalid input.");
  				return;
  			}

        if (t == 1) { //Burger Queen Restaurant
          String username = "Burger Queen";
          String password = "Bq123";
          String filepath = "Restaurant.csv";

          login.VerifyLogin(username, password, filepath);
        } res.resNavi();
      }


      System.out.println("\nPress 0 to exit. Press anything to continue ");
      int x = input.nextInt();

      if (x == 0) {
      	uexit = false;
      }
    } while (uexit);
  }

  public static int findUser (ArrayList<User> ALusr, User usr){
    if (ALusr == null){
      return -1;
    }

    int len = ALusr.size();
    int i =  0;

    while ( i < len ){
      if (ALusr.get(i) == usr) {
        return i;
      }
      else {
        i = i + 1;
      }
  }
    return -1;
  }
}
