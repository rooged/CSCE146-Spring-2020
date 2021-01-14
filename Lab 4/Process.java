//written by Timothy Gedney

public class Process {

	//attributes
	private String name;
	private double time;
	
	//default constructor
	public Process() {
		this.name = "Run";
		this.time = 0;
	}
	
	//parameterized constructor to set variables
	public Process(String aName, double aTime) {
		this.setName(aName);
		this.setCompletionTime(aTime);
	}
	
	//mutators
	public void setName(String aName) {
		this.name = aName;
	}

	public void setCompletionTime(double aTime) {
		//checks that time is greater than 0 and sets equal to 0 if not
		if (aTime >= 0) {
			this.time = aTime;
		} else {
			System.out.println("Time left must be positive.");
			this.time = 0;
		}
	}
	
	//accessors
	public String getName() {
		return this.name;
	}
	
	public double getCompletionTime() {
		return this.time;
	}
	
	//toString
	public String toString() {
		return "Process Name: " + this.getName() + " Completetion Time: " + this.getCompletionTime();
	}
}
