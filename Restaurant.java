/*
OOPDS ASSIGNMENT TRI 1 20/21
Name : Aina Nadhirah Binti Bujang
ID   : 1161302020

Name : Noor 'Alyaa Syazleen Binti Mohamad Nor
ID   : 1171300328

*/

import java.util.Scanner;

public class Restaurant {
	private RestaurantManager rm;
	Menu menu;
	Scanner input = new Scanner(System.in); 
	
	public Restaurant() {
		this.rm = new RestaurantManager();
	}
	
	public void resNavi() {
		System.out.println("\nWhat do you want to do?");
		System.out.println("a Update Foodeliver Menu");
		System.out.println("b Order Status");
		System.out.println("c Order History");
		System.out.print("Selection (a/b/c): ");
		String selectionR = input.next();
		switch (selectionR) {
				case "a":
					resNaviA();
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
	}
	
	public void resNaviA() {
	System.out.println("\nUpdate Foodeliver Menu");
	System.out.println("1 Add / 2 Delete");
	System.out.print("Selection: ");
	int selectionU = input.nextInt();
	if(selectionU == 1) {
		System.out.println("\nAdd dish to restaurant menu");
		addFoodeliverMenu();
		showAll();
		resNavi();
	}else if(selectionU == 2) {
			System.out.println("\nRemove dish from menu");
			removeFoodeliverMenu();
		}
	}
	
	private void addFoodeliverMenu() {
		System.out.print("Code: ");
		int code = input.nextInt();
		
		System.out.print("Name: ");
		String name = input.next();
		
		System.out.print("Price: RM");
		double price = input.nextDouble();
		
		//FoodeliverMenu fm = new FoodeliverMenu(code, name, price);
		this.rm.addFoodeliverMenu(fm);
	}
	
	private void showAll() {
		System.out.println("\n\t\t== a MENU: BURGER QUEEN RESTAURANT==\n");
		System.out.println("\t\tCODE   NAME            PRICE\n\t");
		for(int i = 0; i < this.rm.count(); i++) {
			FoodeliverMenu fm = this.rm.getFoodeliverMenu(i);
			System.out.println("\t\t" + fm.getCode() + "    " + fm.getName() + "         RM" + fm.getPrice() + "0");
		}
	}

	private void removeFoodeliverMenu() {
		System.out.print("Code: ");
		int code = input.nextInt();
		boolean result = this.rm.removeFoodeliverMenu(code);
		if (result) {
			System.out.println("Code " + code + " has been removed from your menu.");
			showAll();
		}else {
			System.out.println("Invalid code!");
		}
	}
}
