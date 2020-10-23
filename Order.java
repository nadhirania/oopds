/**
*@author Aina Nadhirah Binti Bujang
*@author Noor 'Alyaa Syazleen Binti Mohamad Nor
*
*/

import java.util.ArrayList;

public class Order {
	
	/**
	*@param restaurantIndex
	*@param foodNumber
	*@param menu
	*
	*/
	
	private static int orderNum = 0; //initialized to 0
	private ArrayList<FoodeliverMenu> order = new ArrayList<>(); //Arraylist to store all the orders input by customer
	public double totalPrice = 0; //initialized to 0
	String orderDetails = new String(); 
	
	public Order() {}; //default constructor
	
	/**
	*@param restaurantIndex String value
	*@param foodNumber int value
	**/
	
	public void addOrder(String restaurantIndex,int foodNumber, Menu menu) //method to call and pass input of orders(total of items) by customers and add into order
	{  
		switch(restaurantIndex) 
		{
			case "a":
				order.add(menu.getBurgerQueen(foodNumber));
				break;
			
			case "b":
				order.add(menu.getMakKiah(foodNumber));
				break;
			
			case "c":
				order.add(menu.getPastaBox(foodNumber));
				break;
			
			default: 
				break;
		}
	}
	
	/**
	*@param orderNumber int value
	*@return orderDetails
	*/
	public String getOrderName(int orderNumber) //to get the name of items and display
	{
		String orderDetails = order.get(orderNumber).name + " " +order.get(orderNumber).price;
		return orderDetails;
	}
	
	/**
	*@return orderDetails
	*/
	
	public String showOrderList() //to display all of the orders input by customer
	{
		order.forEach((n) -> createOrderList(n.name,n.price)); // calls a function once for each variable name and price in the FoodeliverMenu ArrayList
		return orderDetails;
	}
	
	/**
	*@param name String value
	*@param price double value
	*/
	public void createOrderList(String name, double price) //call and pass value in order to create the order list
	{
		orderDetails += name + " " + price + "\n";
	}
	
	/**
	*@return totalPrice
	*/
	public double countTotal() // to return total of order
	{
		order.forEach((n) -> addTotal(n.price)); // calls a function once for price from FoodeliverMenu ArrayList
		return totalPrice;
	}
	
	/**
	*@param price double value
	*/
	
	public  void addTotal(double price) //calculate total price of order
	{
		totalPrice += price;
	}
	
	/**
	*@return order
	*/

	public ArrayList<FoodeliverMenu> getOrderList()  
	{
		return order;
	}
}