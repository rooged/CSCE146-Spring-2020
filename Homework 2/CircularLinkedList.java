//written by Timothy Gedney

public class CircularLinkedList<T> {
	
	//attributes
	private Node head;
	private Node curr;
	private Node prev;
	private Node tail;
	
	//constructor
	public CircularLinkedList() {
		head = curr = prev = tail = null;
	}
	
	//adds a new node at the end of the list, circular list
	public void add(T data) {
		//creates new node based on object, links the end to the beginning of the list
		Node newNode = new Node(data, head);
		//adds the first node to the head of the list
		if (head == null) {
			head = curr = newNode;
			return;
		//adds the second node to the tail
		} else if (tail == null) {
			tail = newNode;
			head.nextNode = tail;
			prev = head;
			return;
		}
		//if the head and tail are filled already, adds a new node to the tail and relinks the previous tail
		tail.nextNode = newNode;
		prev = tail;
		tail = curr = newNode;
	}
	
	//removes the current node, relinks the nodes to remove it
	public void remove() {
		if (curr == head) {
			head = curr = head.nextNode;
			tail.nextNode = head;
		} else if (curr == tail) {
			tail = prev;
			curr = tail.nextNode = head;
		} else {
			curr = prev.nextNode = curr.nextNode;
		}
	}
	
	//goes to the next node in the list
	public void next() {
		if (curr != null) {
			prev = curr;
			curr = curr.nextNode;
		}
	}
	
	//resets the current value to the head
	public void resetCurrent() {
		curr = head;
		prev = tail;
	}
	
	//returns the current value data
	public T getCurrent() {
		if (curr != null) {
			return curr.data;
		}
		return null;
	}
	
	//returns the toString of the object at current
	public String getName() {
		return curr.data.toString();
	}
	
	//checks if the current is the last node left in the circular list
	public boolean last() {
		if (curr == curr.nextNode) { 
			return true;
		}
		return false;
	}

	//class for node, attributes, and parameterized constructor
	private class Node {
		
		T data;
		Node nextNode;
		
		public Node(T dataValue, Node next) {
			this.data = dataValue;
			this.nextNode = next;
		}
	}
}
