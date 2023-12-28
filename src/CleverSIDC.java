
public class CleverSIDC {
	Structure s = null;
	
	
	public CleverSIDC(long n) {
		if (n<10000&&n>0) {
			s = new LinkedList();
		}
		else if(n>=10000&&n<500000)
			s = new AVLTree();
		else
			System.out.println("Wrong size");
		
	}
	
	public void search(String m) {
		if(s instanceof AVLTree) {
			
			
		}
	}


	public void add(String key, String value) {
		if(s instanceof LinkedList) {
			((LinkedList) s).insert(value);
			
		}
		
		if(s instanceof AVLTree) {
			((AVLTree) s).insert(value);
			
		}
	}
	public void add(String key) {

		if(s instanceof LinkedList) {
			((LinkedList) s).insert(key);
			
		}
		
		if(s instanceof AVLTree) {
			((AVLTree) s).insert(key);
			
		}
	
}
	public void print() {
		if(s instanceof LinkedList) {
			s =((LinkedList) s).merge_sort();
			((LinkedList) s).print();
		}
		
		if(s instanceof AVLTree) {
			((AVLTree)s).print();
		}
		
	}
	public void nextKey(String x) {


		if(s instanceof LinkedList) {
			((LinkedList) s).nextKey(x);
		}
		if(s instanceof AVLTree) {
			((AVLTree)s).getNext(x);
		}
			
	}
	
	public void getPrevious(String x) {

		if(s instanceof LinkedList)((LinkedList)s).getPrevious(x);
	}
	
	public void remove(String key) {


		if(s instanceof LinkedList) {
			((LinkedList) s).remove(key);
			
		}
		
		if(s instanceof AVLTree) {
			((AVLTree) s).remove(key);
			
		}
		
	}
	
	public void getValues(String key) {


		if(s instanceof LinkedList) {
			System.out.println("The value for the given key is: "+((LinkedList) s).search(key));
			
		}
		
		if(s instanceof AVLTree) {
//			System.out.println("The value for the given key is: "+((AVLTree) s).search((AVLTree)s.root,key));
			
		}
		
	}
	
	public void range(String key1, String key2) {
		if (s instanceof LinkedList) {
			
			( (LinkedList)s).rangeKey(key1, key2).print();
			
		}
	}
}
