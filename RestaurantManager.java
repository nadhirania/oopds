/*
OOPDS ASSIGNMENT TRI 1 20/21
Name : Aina Nadhirah Binti Bujang
ID   : 1161302020

Name : Noor 'Alyaa Syazleen Binti Mohamad Nor
ID   : 1171300328

*/


import java.util.ArrayList;

public class RestaurantManager{
	private ArrayList<FoodeliverMenu> burgerQueen;

	public RestaurantManager() {	
		this.burgerQueen = new ArrayList<>();
	}
	
	public int addFoodeliverMenu(FoodeliverMenu fm) {
		this.burgerQueen.add(fm);
		return count();
	}
	
	public int count() {
		return this.burgerQueen.size();
	}
	public FoodeliverMenu getFoodeliverMenu(int index){
		if (index < 0 || index >= count()) {
			return null;
		}
		return this.burgerQueen.get(index);
	}
	
	public boolean removeFoodeliverMenu(int code) {
		int index = -1;
		for(int i = 0, n = count(); i < n; i++) {
			if (this.burgerQueen.get(i).getCode() == code) {
				index = i;
				break;
			}
		}
		if(index!= -1) {
			this.burgerQueen.remove(index);
			return true;
		}
		return false;
	}
}