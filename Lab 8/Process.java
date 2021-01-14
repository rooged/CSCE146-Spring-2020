//written by Timothy Gedney

public class Process implements Comparable<Process> {

	private int priority;
	private double time;
	private String name;
	
	public Process() {
		this.priority = 0;
		this.time = 0.0;
		this.name = "none";
	}
	
	public Process(String aN, int aP, double aT) {
		this.setName(aN);
		this.setPriority(aP);
		this.setTime(aT);
	}
	
	public int getPriority() {
		return this.priority;
	}
	
	public double getTime() {
		return this.time;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setPriority(int aP) {
		if (aP >= 0)
			this.priority = aP;
		else
			this.priority = 0;
	}
	
	public void setTime(double aT) {
		if (aT >= 0.0)
			this.time = aT;
		else
			this.time = 0.0;
	}
	
	public void setName(String aN) {
		if (aN == null)
			this.name = "none";
		else
			this.name = aN;
	}
	
	public String toString() {
		return "Name: " + this.name + " Time: " + this.time + " Priority: " + this.priority;
	}
	
	public int compareTo(Process aP) {
		if (aP == null)
			return 0;
		if (this.priority < aP.getPriority())
			return -1;
		else if (this.priority > aP.getPriority())
			return 1;
		else
			return 0;
	}
}
