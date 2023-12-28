
public class AVLTree extends Structure {
	
	Node root=null;
	Node lastnode= null;
	
	public void adjustHeightBalance(Node n) {
		
		if(n != null) {
		
		

		if(n.left== null &&n.right==null) {
			n.height_balance=0;
			n.height =1;

		}
		else if(n.left==null&&n.right!=null) {
			n.height_balance = 1- n.right.height;
			n.height = n.right.height+1;
		}
		else if(n.left!=null&&n.right==null) {
			n.height_balance = n.left.height -1 ;
			n.height = n.left.height+1;
		}
	}
	
	}

	public void insert(String a) {



		Student s = new Student(a);
		Node n = new Node(s);

		Node pointer = root;

	
		
		//if its empty
		if(root == null) {
			root =n;
			n.height++;
		}
		
		
		
		//its not empty, we need to decide if its larger or smaller then parent node
		else {
			
		while((Long.parseLong(n.st.getKey())<=Long.parseLong(pointer.st.getKey())&&(pointer.left!= null)) ||(Long.parseLong(n.st.getKey())>Long.parseLong(pointer.st.getKey())&&(pointer.right!= null))) {
			
			if(Long.parseLong(n.st.getKey())<=Long.parseLong(pointer.st.getKey())&&(pointer.left!= null)) {
				pointer.height++;
				pointer = pointer.left;
			}
			else if(Long.parseLong(n.st.getKey())>Long.parseLong(pointer.st.getKey())&&(pointer.right!= null)) {
				pointer.height++;
				pointer = pointer.right;
			}
		}
		
		
		
		if(Long.parseLong(n.st.getKey())<=Long.parseLong(pointer.st.getKey())) {
			pointer.height++;

			pointer.left = n;

			n.parent = pointer;
			pointer.left.height++;
			adjustHeightBalance(pointer);

			}
			
		else if(Long.parseLong(n.st.getKey())>Long.parseLong(pointer.st.getKey())) {
			pointer.height++;
			pointer.right = n;

			n.parent = pointer;
			pointer.right.height++;

			adjustHeightBalance(pointer);

			}	
		}
	
		if(pointer!=null)
		check_balance(pointer);

		lastnode = n;
			

		
	}
	//for the balancing act I will use an array of length
	//three from the top 1 will correspond to going right and 0 left
	private void check_balance(Node newnode) {



		Node pointer = newnode;
		String imbalance_type = "";
		while( pointer !=null&&pointer.height_balance<=1&&pointer.height_balance>=-1) {

			pointer = pointer.parent;

		}
		

		if(pointer ==null)
			return;
		
		
		Node problemnode= pointer;
		
		
		//we are at the root of the heightbalance problem
		if(problemnode.height_balance >1) {
			if(problemnode.left.height_balance > 0)
				imbalance_type= "LL";
			else imbalance_type= "LR";
		}
		else if (problemnode.height_balance < -1) {
            // Right heavy
            if (problemnode.right.height_balance < 0) {
                // Right-Right (RR) case
            	imbalance_type= "RR";
            } else {
                // Right-Left (RL) case
            	imbalance_type= "RL";
            }
        }
		
		fix_balance(imbalance_type,problemnode);
		
		
	}
	
	private void fix_balance(String answer, Node problem) {


		switch(answer) {
		case "LL":{
			Node c = problem;
			Node b = c.left;
			Node a = b.left;
			
			b.parent = b.parent.parent;
			b.parent.left = b;
			
			c.left = b.right;
			c.left.parent = c;
			
			b.right = c;
			c.parent = b;
			
			c.height = Math.max(a.right.height, a.left.height)+1;
			b.height = Math.max(b.right.height, b.left.height)+1;
			b.parent.height = Math.max(b.parent.right.height, b.parent.left.height)+1;

			
			adjustHeightBalance(c);
			adjustHeightBalance(b);
			adjustHeightBalance(b.parent);
			
			break;
		}
		
		case "LR": {
			
			Node c = problem;
			Node a = c.left;
			Node b = a.right;
			
			b.parent = c.parent;
			b.parent.left = b;
			
			c.left = b.right;
			c.left.parent = c;
			b.right = c;
			c.parent = b;
			
			a.right = b.left;
			a.right.parent = a;
			b.left = a;
			a.parent = b;
			
			c.height = Math.max(c.right.height, c.left.height)+1;
			a.height = Math.max(a.right.height, a.left.height)+1;
			b.height = Math.max(b.right.height, b.left.height)+1;
			b.parent.height = Math.max(b.parent.right.height, b.parent.left.height)+1;
			
			adjustHeightBalance(b.parent);
			adjustHeightBalance(b);
			adjustHeightBalance(a);
			adjustHeightBalance(c);

			break;
		}
		
		
		case "RR": {
			Node a = problem;
			Node b = a.right;
			Node c = b.right;
			
			b.parent = b.parent.parent;
			b.parent.right = b;
			
			a.right = b.left;
			a.right.parent = a;
			
			b.left = a;
			a.parent = b;
			
			a.height = Math.max(a.right.height, a.left.height)+1;
			b.height = Math.max(b.right.height, b.left.height)+1;
			b.parent.height = Math.max(b.parent.right.height, b.parent.left.height)+1;

			
			adjustHeightBalance(a);
			adjustHeightBalance(b);
			adjustHeightBalance(b.parent);


			break;
		}
		
		
		case "RL": {
			Node a = problem;
			Node c = a.right;
			Node b = c.left;
			
			b.parent = a.parent;
			b.parent.right = b;
			
			a.right = b.left;
			a.right.parent = a;
			b.left = a;
			a.parent = b;
			
			c.left = b.right;
			c.left.parent = c;
			b.right = c;
			c.parent = b;
			
			c.height = Math.max(c.right.height, c.left.height)+1;
			a.height = Math.max(a.right.height, a.left.height)+1;
			b.height = Math.max(b.right.height, b.left.height)+1;
			b.parent.height = Math.max(b.parent.right.height, b.parent.left.height)+1;
			
			adjustHeightBalance(b.parent);
			adjustHeightBalance(b);
			adjustHeightBalance(a);
			adjustHeightBalance(c);
			
			
			break; 
		}
		
		
		default: {System.out.println("avl switch statement default case"); break;}
			
		}
	}
	
	public void remove(String s) {

		Node pointer = searchNode(root, s);
		Node pointerParent = pointer.parent;
		Long pKey = Long.parseLong(pointer.st.getKey());
		Long ppKey = (long) 0;
		if(pointer.parent!= null)
			ppKey = Long.parseLong(pointerParent.st.getKey());
		
		if(pointer.equals(root)) {
			
		}

		if (pointer == null)
			System.out.println("Invalid key");
//		The node does not have children, this means we can simply remove the pointer 
//		and then check the balance all the way to the root.
		else if(pointer.left==null && pointer.right == null) {
//			If its the left child of the parent
			if(pKey<=ppKey) {
				pointerParent.left = null;
				pointer.parent = null;
				pointer = null;
				while(pointerParent!=null ) {
					adjustHeightBalance(pointerParent);
					check_balance(pointerParent);
					pointerParent = pointerParent.parent;
				}
				
			}
			else {
				pointerParent.right = null;
				pointer.parent = null;
				pointer = null;
				while(pointerParent!=null ) {
					adjustHeightBalance(pointerParent);
					check_balance(pointerParent);
					pointerParent = pointerParent.parent;
				}
			}
			
		}
//		If the pointer has a right child but not a left
		else if(pointer.left ==null && pointer.right != null) {
			//check if the pointer is the left child of the parent 
			if(pKey<=ppKey) {
				pointerParent.left = pointer.right;
				pointer.right.parent = pointerParent;
				pointer.parent = null;
				pointer.right = null;
				pointer = null;
				while(pointerParent!=null ) {
					adjustHeightBalance(pointerParent);
					check_balance(pointerParent);
					pointerParent = pointerParent.parent;
				}
				
			}
			else {
				pointerParent.right = pointer.right;
				pointer.right.parent = pointerParent;
				pointer.parent = null;
				pointer.right = null;
				pointer = null;
				while(pointerParent!=null ) {
					adjustHeightBalance(pointerParent);
					check_balance(pointerParent);
					pointerParent = pointerParent.parent;
				}
			}

		}
		else if (pointer.left!=null && pointer.right == null) {
			if(pKey<=ppKey) {
				pointerParent.left = pointer.left;
				pointer.left.parent = pointerParent;
				pointer.parent = null;
				pointer.left = null;
				pointer = null;
				while(pointerParent!=null ) {
					adjustHeightBalance(pointerParent);
					check_balance(pointerParent);
					pointerParent = pointerParent.parent;
				}
				
			}
			else {
				pointerParent.right = pointer.left;
				pointer.left.parent = pointerParent;
				pointer.parent = null;
				pointer.left = null;
				pointer = null;
				while(pointerParent!=null ) {
					adjustHeightBalance(pointerParent);
					check_balance(pointerParent);
					pointerParent = pointerParent.parent;
				}
			}
		}
		else if(pointer.left!= null && pointer.right != null) {
			Node replacementNode = NextNodeInorder(pointer.right);
			pointer.copyNode(replacementNode);
			
			
			if(!replacementNode.parent.equals(pointer)) {
			if(replacementNode.right!=null) {
				replacementNode.parent.left = replacementNode.right;
				replacementNode.right.parent = replacementNode.parent;
				replacementNode.right = null;
			}

			replacementNode.parent = null;
			replacementNode = null;
			
			
		}
			else {
				pointer.right= replacementNode.right;
				replacementNode.parent= pointer;
				replacementNode.parent = null;
				replacementNode.right = null;
			}
			
			while(pointerParent!=null) {
				adjustHeightBalance(pointerParent);
				check_balance(pointerParent);
				pointerParent = pointerParent.parent;
			}
		}
		}
		
	private Node NextNodeInorder(Node n) {
		
		if (n.left!= null)
			return NextNodeInorder(n.left);
		
		return n;
		
	}
				
	public void inorderTraversalprint(Node n) {


		if(n.left!= null) {
			inorderTraversalprint(n.left);
		}
		System.out.println(n);
		if(n.right!=null)
			inorderTraversalprint(n.right);
		
	}
	
	public String search(Node n, String y) {


		Node pointer = n;
		Long key = Long.parseLong(y);
		if(key == Long.parseLong(pointer.st.getKey()))
				return "Student name: "+pointer.st.getValue()+". Student key: "+pointer.st.getKey();
		else if(key<Long.parseLong(pointer.st.getKey())&& pointer.left!=null)
			search(pointer.left,y);
		else if(key>Long.parseLong(pointer.st.getKey())&& pointer.right!=null)
			search(pointer.right,y);
		
		return "key not found";
	}
	
	public Node searchNode(Node n, String y) {

		Node pointer = n;
		Long key = Long.parseLong(y);
		
		if (root ==null) {
			System.out.println("This adt is empty");
			return root;}
		if(key == Long.parseLong(pointer.st.getKey()))
				return pointer;
		else if(key<Long.parseLong(pointer.st.getKey())&& pointer.left!=null)
			 return searchNode(pointer.left,y);
		else if(key>Long.parseLong(pointer.st.getKey())&& pointer.right!=null)
			return searchNode(pointer.right,y);
		
		return null;
		
		
	}

	public void print() {
		inorderTraversalprint(root); 
		
	}
	
	public void getNext(String k) {
		Node tempNode = searchNode(root,k);
		if(tempNode.right!=null)
			System.out.println(NextNodeInorder(tempNode.right));
		
		
		else if(tempNode.parent.left != null &&tempNode.equals(tempNode.parent.left))System.out.println(tempNode.parent);
		else System.out.println(tempNode.parent.parent);
	
	}
	
	public Node previousNode (String k) {
		
		
		return null;
	}
	
	class Node{
		Student st=null;
		Node left=null;
		Node right=null;
		 Node parent=null;
		private int height = 0;
		private int height_balance = 0;


		private Node (Student newst) {
			this.st = newst;
		}
		public String toString() {
			return "Student name : " + this.st.getValue() + ". Student key: " + this.st.getKey();
		}
		
		private boolean equals(Node n) {
			if (Long.parseLong(this.st.getKey())==Long.parseLong(n.st.getKey()))
				return true;
			else return false;
			
		}
		
		private void copyNode(Node n) {
			this.st.setKey(n.st.getKey());
			this.st.setValue(n.st.getValue());
		}
	}
}
