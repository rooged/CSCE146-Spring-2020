//written by Timothy Gedney

public class GenStack<T> implements StackInterface<T> {
	
	private ListNode head; //always first element
	private int size; //size of the stack
	
	//constructor
	public GenStack() {
		head = null;
		size = 0;
	}
	
	//adds a new node at the beginning of the list
	@Override
	public void push(T aData) {
		//creates new node based on object
		ListNode newNode = new ListNode(aData, null);
		//adds the first node to the head of the list if its empty
		if (head == null) {
			head = newNode;
			size++;
			return;
		}
		//adds the node to the head and relinks old head to be next
		ListNode temp = head;
		head = newNode;
		head.link = temp;
		size++;		
	}
	
	//removes the head and returns it
	@Override
	public T pop() {
		ListNode temp = head;
		if (head.link != null) {
			head = head.link;
		} else {
			head = null;
		}
		size--;
		return temp.data;
	}
	
	//returns the head value data
	@Override
	public T peek() {
		return head.data;
	}
	
	//prints out the entire stack
	@Override
	public void print() {
		ListNode temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.link;
		}
	}
	
	//returns size of the stack
	public int getSize() {
		return size;
	}

	//class for node, attributes, and parameterized constructor
	private class ListNode {
		T data;
		ListNode link;
		
		public ListNode(T aData, ListNode aLink) {
			data = aData;
			link = aLink;
		}
	}
}
