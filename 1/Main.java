import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class Main {
  public static void main(String[] args) throws IOException {
    VerifyLogin login = new VerifyLogin();
    Database db = new Database();
    Restaurant res = new Restaurant();
    Customer cus = new Customer();
    Scanner input = new Scanner(System.in);

		System.out.println("\n\tWELCOME TO FOODELIVER");

		System.out.println("\nChoose Role: ");
		System.out.println("1 Customer");
		System.out.println("2 Restaurant");
		System.out.println("3 Admin");
    System.out.println("4 Rider \n");
		System.out.print("> ");
		int r = input.nextInt();
		if (r > 5) {
			System.out.println("Invalid input!");
			return;
		}

		if (r == 1) { // CUSTOMER
			System.out.println("\n\t-> CUSTOMER <-\n");

      String username = "Ali";
      String password = "Ali123";
      String filepath = "Customer.csv";

      login.VerifyLogin(username, password, filepath);

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
  }
}
