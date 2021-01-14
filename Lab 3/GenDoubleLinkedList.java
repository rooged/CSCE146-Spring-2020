//written by Timothy Gedney

public class GenDoubleLinkedList<T> {

	//class for node, attributes, and default & parameterized constructor, double linked list
	private class ListNode {
		T data;
		ListNode nextLink;
		ListNode prevLink;
		
		public ListNode() {
			data = null;
			nextLink = null;
			prevLink = null;
		}
		
		public ListNode(T aData, ListNode aNextLink, ListNode aPrevLink) {
			data = aData;
			nextLink = aNextLink;
			prevLink = aPrevLink;
		}
	}
	
	//attributes of the beginning of the list and the current selection
	private ListNode head;
	private ListNode current;
	
	//default constructor
	public GenDoubleLinkedList() {
		head = new ListNode();
		head = current = null;
	}
	
	//changes current to the next node in the list
	public void goToNext() {
		if (current != null && current.nextLink != null) {
			current = current.nextLink;
		}
	}
	
	//changes current to the previous node in the list
	public void goToPrev() {
		if (current != null && current.prevLink != null) {
			current = current.prevLink;
		}
	}
	
	//checks if there's a node after the current
	public boolean moreToIterate() {
		return current.nextLink != null;
	}
	
	//resets current to the beginning of the list
	public void resetCurrent() {
		current = head;
	}
	
	//returns the current value data
	public T getCurrent() {
		if (current != null) {
			return current.data;
		}
		return null;
	}
	
	//takes in an object and sets the current node to that object
	public void setCurrent(T aData) {
		if (current != null) {
			current.data = aData;
		}
	}
	
	//adds a new node at the end of the list
	public void insert(T aData) {
		//creates new node based on object
		ListNode newNode = new ListNode(aData, null, null);
		//adds the first node to the head of the list
		if (head == null) {
			head = current = newNode;
			return;
		}
		//if the head is already filled, adds the new node to the next space and links everything together
		ListNode temp = head;
		while (temp.nextLink != null) {
			temp = temp.nextLink;
		}
		temp.nextLink = newNode;
		newNode.prevLink = temp;
	}
	
	//inserts a new node after the current node, relinks the current node and next node to fit in the new node
	public void insertAfterCurrent(T aData) {
		ListNode newNode = new ListNode(aData, null, null);
		if (current != null) {
			newNode.nextLink = current.nextLink;
			current.nextLink = newNode;
			newNode.nextLink.prevLink = newNode;
			newNode.prevLink = current;
		}
	}
	
	//removes the current node
	public void deleteCurrent() {
		//if the current is the head, makes current and head the next node and removes the next nodes previous link
		if (current != null && current.prevLink == null) {
			head = current = head.nextLink;
			head.prevLink = null;
		//if the current is the tail, makes current and tail the previous node and removes the previous nodes next link
		} else if (current != null && current.nextLink == null) {
			current = current.prevLink;
			current.nextLink = null;
		} else {
		//resets the previous nodes link to the node after the current, changes next nodes previous link to the previous node
			current.nextLink.prevLink = current.prevLink;
			current.prevLink.nextLink = current = current.nextLink;
		}
	}
	
	//prints out the list, while loop checks that the next node isn't null
	public void print() {
		ListNode temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.nextLink;
		}
	}
	
	//takes in an object, uses a while loop to compare the input object to the object in a node, returns true if any node matches
	public boolean contains(T aData) {
		ListNode temp = head;
		while (temp != null) {
			if (temp.data == aData) {
				return true;
			}
			temp = temp.nextLink;
		}
		return false;
	}
}

