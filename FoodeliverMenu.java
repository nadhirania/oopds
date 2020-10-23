/*
OOPDS ASSIGNMENT TRI 1 20/21
Name : Aina Nadhirah Binti Bujang
ID   : 1161302020

Name : Noor 'Alyaa Syazleen Binti Mohamad Nor
ID   : 1171300328

*/

import java.util.ArrayList;

public class FoodeliverMenu {
	public int code;
	public String name;
	public double price;
	
	public FoodeliverMenu() {}
	public FoodeliverMenu (int code, String name, double price) {
		this.code = code;
		this.name = name;
		this.price = price;
	}
	
	//accessor
	public int getCode(){
		return code;
	}
	
	public String getName(){
		return name;
	}
	
	public double getPrice(){
		return price;
	}
	
	//mutator
	public void setCode(int code) {
		this.code = code;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString(){
		return "\t\t" + code + "      " + name + "   RM" + price + "0";
	}
}

class Menu {
	private ArrayList<FoodeliverMenu> burgerQueen= new ArrayList<>();
	private ArrayList<FoodeliverMenu> makKiah= new ArrayList<>();
	private ArrayList<FoodeliverMenu> pastaBox = new ArrayList<>();	
	
	public Menu() {
		menuListBQ();
		menuListMK();
		menuListPB();
	}
	
	//return a specific dish
	public  FoodeliverMenu getBurgerQueen(int index) {
		return burgerQueen.get(index);
	}
	
	public  FoodeliverMenu getMakKiah(int index) {
		return makKiah.get(index);
	}
	
	public  FoodeliverMenu getPastaBox(int index) {
		return pastaBox.get(index);
	}

	public int getBurgerQueenSize() {
		return  burgerQueen.size();
	}

	public String getMenuBurgerQueen() {
		String bqMenu = "";
		System.out.println("\n\t\t== a MENU: BURGER QUEEN RESTAURANT==\n");
		System.out.println("\t\tCODE    NAME                   PRICE\n\t");	
		
		for (int i = 0; i < burgerQueen.size(); i++) {
			FoodeliverMenu bq = burgerQueen.get(i);
			bqMenu += bq.toString() + "\n";
		}
		return bqMenu;
	}
	
	public String getMenuMakKiah() {
		String mkMenu = "";
		System.out.println("\n\t\t== b MENU: MAK KIAH RESTAURANT ==\n");
		System.out.println("\t\tCODE    NAME                   PRICE\n\t");
		
		for (int i = 0; i < makKiah.size(); i++) {
			FoodeliverMenu mk = makKiah.get(i);
			mkMenu += mk.toString() + "\n";
		}
		return mkMenu;
	}
	
	public String getMenuPastaBox() {
		String pbMenu = "";
		System.out.println("\n\t\t== c MENU: PASTA BOX RESTAURANT==\n");
		System.out.println("\t\tCODE    NAME                          PRICE\n\t");	
		
		for (int i = 0; i < pastaBox.size(); i++) {
			FoodeliverMenu pb = pastaBox.get(i);
			pbMenu += pb.toString() + "\n";
		}
		return pbMenu;
	}
	
	//Menu List 
		//Burger Queen Menu
	public void menuListBQ() {
		burgerQueen.add(new FoodeliverMenu( 1," Whopper             ", 13.4));
		burgerQueen.add(new FoodeliverMenu( 2," Tendergrill         ", 13.4));
		burgerQueen.add(new FoodeliverMenu( 3," Double Cheese Burger", 12.4 ));
		burgerQueen.add(new FoodeliverMenu( 4," French Fries        ", 4.5));
		burgerQueen.add(new FoodeliverMenu( 5," Coca-Cola           ", 3.9));
		//FoodeliverMenu fm = new FoodeliverMenu(code, name, price);
	}
	
		//Mak Kiah Menu
	public void menuListMK() {
		makKiah.add(new FoodeliverMenu         (1," Nasi Lemak          ",2.7));
		makKiah.add(new FoodeliverMenu         (2," Fried Mee           ",5));
		makKiah.add(new FoodeliverMenu		   (3," Fried Rice          ",6));
		makKiah.add(new FoodeliverMenu		   (4," Iced Milo           ",1.8));
		makKiah.add(new FoodeliverMenu		   (5," Iced Tea            ",1.7));
		FoodeliverMenu fm = new FoodeliverMenu(FoodeliverMenu.getCode(), FoodeliverMenu.getName(), FoodeliverMenu.getPrice());
	}
		//PastaBox Menu
	public void menuListPB() {
		pastaBox.add(new FoodeliverMenu		   (1,"Spaghetti Chicken Carbonara",12.5));
		pastaBox.add(new FoodeliverMenu		   (2,"Spaghetti Chicken Bolognese",12.5));
		pastaBox.add(new FoodeliverMenu		   (3,"Spaghetti Aglio Olio       ",12.5));
		pastaBox.add(new FoodeliverMenu		   (4,"Mineral Water              ",1));
		pastaBox.add(new FoodeliverMenu		   (5,"Iced Lemon Tea             ",2));
		//FoodeliverMenu fm = new FoodeliverMenu(code, name, price);
	}
}