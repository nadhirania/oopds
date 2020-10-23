/*
OOPDS ASSIGNMENT TRI 1 20/21
Name : Aina Nadhirah Binti Bujang
ID   : 1161302020

Name : Noor 'Alyaa Syazleen Binti Mohamad Nor
ID   : 1171300328

*/

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Menu menu = new Menu();
		Order order = new Order();
		Restaurant res = new Restaurant();
		//FoodeliverMenu fm = new FoodeliverMenu();
		String user, pass;
		
		Scanner input = new Scanner(System.in);
		Scanner userPass = new Scanner(System.in);
		System.out.println("\n\tWELCOME TO FOODELIVER");
		System.out.println("\nChoose Role: ");
		System.out.println("1 Customer");
		System.out.println("2 Restaurant \n");
		System.out.print("> ");
		int r = input.nextInt();
		if (r > 2) {
				System.out.println("Invalid input!");
				return;
			}
		
		if (r == 1) { // CUSTOMER
			System.out.println("\n\t-> Customer <-\n");
			
			//Login input (Customer)
			System.out.print("Username[Case sensitive!]: ");
			user = userPass.nextLine();

			System.out.print("Password[Case sensitive!]: ");
			pass = userPass.nextLine();
			
			if (user.equals("Ali") && (pass.equals("Ali1989"))) {
			} else if (user.equals("Cheng") && (pass.equals("Cheng88"))) {				
			} else if (user.equals("Muthu") && (pass.equals("Muthu2007"))) {
			} else {
				System.out.println("Invalid login info!");
				return;
			}
			System.out.println("\nWelcome " + user + "!");
	
			System.out.println("\na Foodeliver Menu");
			System.out.println("b Order Status");
			System.out.println("c Order History");

			System.out.print("Selection (a/b/c): ");
			String selectionC = input.next();
			switch (selectionC) {
				case "a":
					System.out.println("\nFoodeliver Menu");

					System.out.println(menu.getMenuBurgerQueen());
					System.out.println(menu.getMenuMakKiah());
					System.out.println(menu.getMenuPastaBox());
					
					System.out.println("You can only select one Restaurant. Choose restaurant(a/b/c) : ");
					String RestaurantSelect = input.next();
					
					switch(RestaurantSelect) {
						case "a"	:	
							System.out.println("You have selected BURGER QUEEN RESTAURANT ");
							break;
						case "b"	: 	
							System.out.println("You have selected MAK KIAH RESTAURANT ");
							break;
						case "c"	:	
							System.out.println("You have selected PASTA BOX RESTAURANT ");
							break;
					}
					
					System.out.println("Press 0 to finish.");
					System.out.print("Choice of food (Insert code of dish selection): \n");
					int dish;
					int count = 0;
					do{
						dish = input.nextInt();
						if(dish != 0){
						order.addOrder(RestaurantSelect, dish - 1, menu);
						System.out.println(order.getOrderName(count) + " added to cart");
						count++;
						}
					}while(dish!=0);
					System.out.println("\n\nYour order details : ");
					
					System.out.println(order.showOrderList());

					System.out.println("You ordered " + (count) + " items from the selected restaurant.");
					System.out.println("Total price is " + order.countTotal());
					break;

				case "b":
					System.out.println("\nOrder Status");
					break;
				
				case "c":
					System.out.println("\nOrder History");
					break;
					
				default:
					System.out.println("Invalid input.");
			}
		} else if (r == 2) { //RESTAURANT
			System.out.println("\n\t-> Restaurant <-\n");
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
			
			//Login input (Restaurant)
			System.out.print("\nUsername[Case sensitive!]: ");
			user = userPass.nextLine();

			System.out.print("Password[Case sensitive!]: ");
			pass = userPass.nextLine();
			
			if (t == 1) { //Burger Queen Restaurant
				if(user.equals("Burger Queen") && (pass.equals("Bq123"))) {
					System.out.println(menu.getMenuBurgerQueen());
				}else{
					System.out.println("Invalid login info!");
					return;
				}
			} else if (t == 2) { //Mak Kiah Restaurant
				if (user.equals("Mak Kiah") && (pass.equals("Mk123"))) {
					System.out.println(menu.getMenuMakKiah());
				} else{
					System.out.println("Invalid login info!");
					return;
				}
			} else if (t == 3) { //Pasta Box Restaurant
				if (user.equals("Pasta Box") && (pass.equals("Pb123"))) {
					System.out.println(menu.getMenuPastaBox());
				}else{
					System.out.println("Invalid login info!");
					return;
				}
			}
			res.resNavi();
		}
	}
}