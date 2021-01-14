//written by Timothy Gedney

public class Prize {

	//attributes
	private String name;
	private int price;
	
	//constructors
	public Prize() {
		this.name = "Car";
		this.price = 20000;
	}
	
	public Prize(String name, int price) {
		this.setName(name);
		this.setPrice(price);
	}
	
	//mutators
	public void setName(String prizeName) {
		this.name = prizeName;
	}
	
	public void setPrice(int prizePrice) {
		this.price = prizePrice;
	}
	
	//accessors
	public String getName() {
		return this.name;
	}
	
	public int getPrice() {
		return this.price;
	}
}
