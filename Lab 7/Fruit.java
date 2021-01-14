//written by Timothy Gedney

public class Fruit implements Comparable<Fruit> {

	private double weight;
	private String type;
	
	public Fruit() {
		this.weight = 1.0;
		this.type = "none";
	}
	
	public Fruit(String aT, double aW) {
		this.setType(aT);
		this.setWeight(aW);
	}
	
	public double getWeight() {
		return this.weight;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void setWeight(double aW) {
		if (aW <= 0.0) {
			this.weight = 1.0;
		} else {
			this.weight = aW;
		}
	}
	
	public void setType(String aT) {
		if (aT == null)
			this.type = "none";
		else
			this.type = aT;
	}
	
	public String toString() {
		return this.type + " " + this.weight;
	}
	
	public int compareTo(Fruit aFruit) {
		if (aFruit == null)
			return 0;
		if (this.weight > aFruit.getWeight())
			return 1;
		else if (this.weight < aFruit.getWeight())
			return -1;
		else
			return 0;
	}
}
