//written by Timothy Gedney

public class LinkedListQueue<T> {

	//class for node, attributes, and parameterized constructor
	private class ListNode {
		T data;
		ListNode link;
		
		public ListNode(T aData, ListNode aLink) {
			data = aData;
			link = aLink;
		}
	}
	
	//attributes
	private ListNode head; //always first element
	private ListNode tail; //always the last element
		
	//default constructor
	public LinkedListQueue() {
		head = tail = null;
	}
	
	//parameterized constructor
	public LinkedListQueue(T aData) {
		Enqueue(aData);
	}
		
	//adds a new node to the end of the list
	public void Enqueue(T aData) {
		//creates new node and if the head is empty, sets head to the node
		ListNode newNode = new ListNode(aData, null);
		if (head == null) {
			head = newNode;
			return;
		//if the tail is empty then sets tail to the node
		} else if (tail == null) {
			tail = newNode;
			head.link = tail;
			return;
		}
		//adds the new node onto the end of the list
		tail.link = newNode;
		tail = newNode;
	}
	
	//removes the first node of the list and returns the data
	public T Dequeue() {
		if (head != null) {
			T ret = head.data;
			head = head.link;
			return ret;
		}
		System.out.println("Queue is empty.");
		return null;
	}
	
	//returns the data of the next node in the list
	public T Peek() {
		if (head != null) {
			return head.data;
		}
		System.out.println("Queue is empty.");
		return null;
	}

	//prints out the linked list
	public void Print() {
		ListNode temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.link;
		}
	}
}
