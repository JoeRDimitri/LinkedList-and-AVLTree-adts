
public class LinkedList {
	private Node head = null;
	private Node tail = null;

	
	public LinkedList() {
		
	}
	
	public LinkedList(Node n) {
		this.head = n;
		Node pointer = head;
		while(pointer.next != null) {
			pointer = pointer.next;
		}
		tail = pointer; 
	}
	
	public LinkedList(Student newst) {

		Node tempnode = new Node(newst);
		if(head==null&&tail==null) {
		head = tempnode;
		tail = tempnode;
		}
		
	}
	
	public void insert(Node newnode){

		Node tempnode = this.tail;

		//empty linked list
		if(head==null&&tail==null) {
			head = newnode;
			tail = newnode;
			}
		//one element in linked list
		else if (head.next == null) {
			this.tail = newnode;
			head.next = newnode;
			tail.previous = head;
		}
		
		//more than one element in linkedlist. 
		else {
			this.tail = newnode;
			this.tail.previous = tempnode;
			tempnode.next = newnode;
		}
		

		
	}
	
	public void remove(long key) {
		
		//check if head is key
		if(head.st.getKey() == key) {
			head = head.next;
			head.previous.next = null;
			head.previous = null;
		}
		
		else {
			//if its not the head check the rest
			Node pointer = head.next;

			while(pointer !=null) {
				//check if the value is the key
				if(pointer.st.getKey() == key) {
					pointer.previous.next = pointer.next;
					pointer.next.previous = pointer.previous;
					pointer.previous = null;
					pointer.next = null;
				}
				
				pointer = pointer.next;
			}
		
		}
		
		
	}
	
	public String search(long key) {
		
		//check the head
		if(head.st.getKey() == key)
			return head.st.getValue();
		
		else {
			Node pointer = head.next; 
			while(pointer.next != null) {
				if(pointer.st.getKey()==key)
					return pointer.st.getValue();
				pointer = pointer.next;
			}
		}
		
		return "Key Does not Exist";
	}
	
	public LinkedList allkey() {
		//mergesort the linkedlist:
		
		return new LinkedList(merge_sort(this));
		
		
	}
	
	private Node merge_sort(LinkedList l) {
		
		//Base case if list has one element then n.next = null;
		if(l.head.next == null)
			return l.head;
		
		
		//Split into smaller linkedlists until a single value is reached. 
		//When the smallest value is reached then compare the two value and merge accordingly.

		Node midnode = getMidNode(l);
		
		
		//disconnect the two Linkedlists to create two speerate lists
		
		
		midnode.previous.next = null;
		midnode.previous = null; 
		
		merge_sort(new LinkedList(head));
		merge_sort(new LinkedList (midnode));

		return merge(head, midnode);
		
	}
	
	private Node merge(Node list1, Node list2) {
		Node pointer1 = list1;
		Node pointer2 = list2;
		
		while(pointer1!= null && pointer2 != null) {
			if(pointer1.st.getKey()<=pointer2.st.getKey())
				pointer1 = pointer1.next;
			else {
				Node dummypointer = null;
				dummypointer = pointer2;
				pointer2 = pointer2.next;
				
				if(dummypointer.previous!= null)
				dummypointer.previous.next = pointer2;
				pointer2.previous = dummypointer.previous ;
				
				dummypointer.previous = pointer1.previous;
				dummypointer.next = pointer1;
				dummypointer.previous.next = dummypointer;
			}		
		}
		
		return list1;
		
	}
	
	private Node getMidNode(LinkedList l) {
		Node pointer = l.head;
		Node midnode = null;
		int size = 0;
		while(pointer.next != null) {
			size++;
			pointer = pointer.next;
		}
		
		for (int i = 0; i < (size/2)-1; i++) {
			midnode = midnode.next;
			//left subtree will be smaller or equal to right.
		}
		
		return midnode; 
		
	}
	
	public Student getNextKey(long key) {

		Node pointer = head;
		while(pointer != null) {
			if(pointer.st.getKey()==key)
				return pointer.next.st;
			else pointer = pointer.next;
		}
		System.out.println("Not valid key");
		return null;
		
	}
	
	public Student getPreviousKey(long key) {
		Node pointer = head; 
		while(pointer != null) {
			if (pointer.st.getKey()== key)
				return pointer.previous.st;
			pointer = pointer.next;
		}
		System.out.println("Not valid Key");
		return null;
		
	}

	public LinkedList rangeKey(long k1, long k2) {
		Node pointer1=head;
		Node pointer2 = head;
		while(pointer1 != null && pointer2 !=null) {
			if(pointer1.st.getKey()!=k1)
				pointer1 = pointer1.next;
			if(pointer2.st.getKey()!=k2)
				pointer2 = pointer2.next; 
				
		}
		
		
		
	}

	private class Node {

		Student st;
		Node next = null;
		Node previous = null;
	
		
		
		
		
		private Node (Student newst) {
			this.st = newst;
		}
		
	
		
	}
	
	
}
