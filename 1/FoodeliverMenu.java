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

	public String toString(){
		//return code + " " + name + " " + price;
		return "";
	}

	public String toCSVString() {
		return code + "," + name + "," + price;
	}
}
