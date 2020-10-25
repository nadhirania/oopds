public class FoodeliverMenu {
	private int code;
	private String name;
	private double price;

	public FoodeliverMenu() {}
	public FoodeliverMenu (int code, String name, double price) {
		this.code = code;
		this.name = name;
		this.price = price;
	}

	public int getCode(){
		return code;
	}

	public String getName(){
		return name;
	}

	public double getPrice(){
		return price;
	}

	public void setName(String newName){
		this.name = newName;
	}

	public void setPrice(double newPrice){
		this.price = newPrice;
	}

	public String toString(){
		return code + " " + name + " " + " RM" + price + "0 " + "\n";
	}

	public String toCSVString() {
		return code + "," + name + "," + price;
	}
}
