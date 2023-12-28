
public class LinkedList extends Structure {
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
	
	public void insert(String s){

		Student newstudent = new Student(s);
		
		Node newnode = new Node(newstudent);


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
	
	
	public void remove(String key) {


		
		//check if head is key
		if(Long.parseLong(head.st.getKey()) == Long.parseLong(key)) {
			head = head.next;
			head.previous.next = null;
			head.previous = null;
		}
		
		//check if tail is key
		else if(Long.parseLong(tail.st.getKey()) == Long.parseLong(key)) {
			tail=tail.previous;
			tail.next.previous=null;
			tail.next=null;
		}
		
		else {
			//if its not the head check the rest
			Node pointer = head.next;

			while(pointer !=null) {
				//check if the value is the key
				if(Long.parseLong(pointer.st.getKey()) == Long.parseLong(key)) {
					pointer.previous.next = pointer.next;
					if(pointer.next!=null)
					pointer.next.previous = pointer.previous;
					pointer.previous = null;
					pointer.next = null;
				}
				
				pointer = pointer.next;
			}
		
		}
		
		
	}
	
	public String search(String key) {

		
		//check the head
		if(Long.parseLong(head.st.getKey()) == Long.parseLong(key))
			return head.st.getValue();
		
		else {
			Node pointer = head.next; 
			while(pointer != null) {
				if(Long.parseLong(pointer.st.getKey())==Long.parseLong(key))
					return pointer.st.getValue();
				pointer = pointer.next;
			}
		
		}
		
		return "Key Does not Exist";
	}
	
	protected LinkedList allkey() {



		//mergesort the linkedlist:
		
		return merge_sort();
		
		
	}
	
	protected LinkedList merge_sort() {




				
		//Base case if list has one element then n.next = null;
		if(this.head.next == null)
			return this;
		
		//Split into smaller linkedlists until a single value is reached. 
		//When the smallest value is reached then compare the two value and merge accordingly.

		Node midnode = getMidNode(this);
		
		
		LinkedList secondhalf = new LinkedList( midnode.next);

			midnode= midnode.next;
			midnode.previous.next = null;
			midnode.previous = null; 
		
	
		//disconnect the two Linkedlists to create two speerate lists
		


		LinkedList sortedfirsthalf = this.merge_sort();
		LinkedList sortedsecondhalf = secondhalf.merge_sort();

		
		
		return merge(sortedfirsthalf, sortedsecondhalf);
		
	}
	
	private Node getMidNode(LinkedList l) {


		
		if(this.head == null)
			return null;
		Node pointer = l.head;
		Node midnode = l.head;
		int size = 0;
		while(pointer.next != null) {
			size++;
			pointer = pointer.next;
		}
		size++;
		
		for (int i = 0; i < (size/2)-1; i++) {
			midnode = midnode.next;
			//left subtree will be smaller or equal to right.
		}
		
		return midnode; 
		
	}
	
	public Node pointerSearch(String key) {


		
		//check the head
		if(Long.parseLong(head.st.getKey()) == Long.parseLong(key))
			return head;
		
		else {
			Node pointer = head.next; 
			while(pointer != null) {
				if(Long.parseLong(pointer.st.getKey())==Long.parseLong(key))
					return pointer;
				pointer = pointer.next;
			}
		}
		
		return null;
	}
	
	private LinkedList merge(LinkedList list1, LinkedList list2) {

		Node pointer1 = list1.head;
		Node pointer2 = list2.head;
		LinkedList S = new LinkedList();
		
		while(pointer1!= null && pointer2 != null) {
			if(Long.parseLong(pointer1.st.getKey())<=Long.parseLong(pointer2.st.getKey())) {
				S.insert(pointer1);
				pointer1 = pointer1.next;
			}
			else {
				S.insert(pointer2);
				pointer2 =pointer2.next;

			}		
		}
		
		while(pointer1== null && pointer2 != null) {
			
				S.insert(pointer2);
				pointer2 =pointer2.next;
			}
		while(pointer1!= null && pointer2 == null) {
			
			S.insert(pointer1);
			pointer1 =pointer1.next;
		}
	
		
		return S;	
	}
	
	
	
	
	public void getPrevious(String s) {

		Node pointer = this.pointerSearch(s);
		
		if(pointer==null) {
			System.out.println("Your input is invalid, it is not in the list");
		}
		else if(pointer == head) {
			System.out.println(this.tail);
		}
		else {
			System.out.println(pointer.previous);
		}
		
	}
	
	

	public LinkedList rangeKey(String k1, String k2) {

		merge_sort();

		long tk1=0,tk2=0;
		LinkedList newlist=new LinkedList();
		if(Long.parseLong(k1)>Long.parseLong(k2)) {
			 tk2 = Long.parseLong(k1);
			 tk1 = Long.parseLong(k2);
		}
		else {
			tk1 = Long.parseLong(k1);
			tk2 = Long.parseLong(k2);
		}

		Node pointer1=head;
		Node pointer2 = head;
		while(pointer1.next != null && Long.parseLong(pointer1.st.getKey())!=tk1 ) {
			if(Long.parseLong(pointer1.st.getKey())!=tk1) {
				pointer1 = pointer1.next;
				}
			else break;
		}
		if(pointer1 ==null) {
			System.out.println("Invalid key 1");
			return null;
		}
		
		pointer2 = pointer1;
		while(pointer2!=null&& Long.parseLong(pointer2.st.getKey())!=tk2) {
			if(Long.parseLong(pointer2.st.getKey())!=tk2)
				pointer2 = pointer2.next;
		}
		
		if(pointer2 ==null) {
			System.out.println("Invalid key 1");
			return null;
		}
		
		Node pointer = pointer1;
		while(pointer!=pointer2.next) {
			newlist.insert(pointer);
			pointer = pointer.next;
		}
		
		return newlist;
		
		
	}

	public void nextKey(String s) {

		Node pointer = this.pointerSearch(s);
		
		if(pointer==null) {
			System.out.println("Your input is invalid, it is not in the list");
		}
		else if(pointer == tail) {
			System.out.println(this.head);
		}
		else {
			System.out.println(pointer.next);
		}
		
	}
	
	public void print() {


		Node pointer = head;

		while(pointer.next!= null) {
			System.out.println(pointer);
			pointer = pointer.next;
		}		

		System.out.println(pointer);
//		
//		System.out.println();
//		System.out.println();
//
//		System.out.println();
//
//		System.out.println();
//		System.out.println();
//		System.out.println();

	}
	private class Node {

		Student st;
		Node next = null;
		Node previous = null;
	
		
		
		
		
		private Node (Student newst) {
			this.st = newst;
		}
		
		public String toString() {
			return "Student name : " + this.st.getValue() + ". Student key: " + this.st.getKey();
		}
		
	
		
	}
	
	
}
