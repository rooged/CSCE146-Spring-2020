//written by Timothy Gedney

public class ProcessScheduler {

	//attributes, initializes LinkedListQueue<T> class with Process object
	private LinkedListQueue<Process> processes = new LinkedListQueue<Process>();
	private Process current;
	
	//returns the current process
	public Process getCurrentProcess() {
		return current;
	}
	
	//takes in a Process object and adds it to the list
	public void addProcess(Process aP) {
		if (current == null) {
			current = aP;
			return;
		}
		processes.Enqueue(aP);
	}
	
	//uses the Dequeue method to remove the head of the list and set it to current
	public void runNextProcess() {
		current = processes.Dequeue();
	}
	
	//cancels current process, then uses Dequeue to set head of the list to current
	public void cancelCurrentProcess() {
		current = null;
		current = processes.Dequeue();
	}
	
	//prints list
	public void printProcessQueue() {
		if (processes != null) {
			processes.Print();
		}
	}
}
