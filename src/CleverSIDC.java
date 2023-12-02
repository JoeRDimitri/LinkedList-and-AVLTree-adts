
public class CleverSIDC {
	
	
	public LinkedList list = null;
	public AVLtree tree = null;
	
	public CleverSIDC() {
	}
	
	
	public void SetSIDCThreshold(int size) {
		
		if (size<0) {System.out.println("Invalid size. Program Terminate.");
		System.exit(0);}
		
		if(size<1000)
			this.list = new LinkedList();
		else
			this.tree = new AVLtree();
	}
	
	public void add(int key, String value) {
		
		
	}
	
	
	
	
	
	
	private class AVLtree{
		protected Node root = null;
		protected Node Lchild;
		protected Node Rchild;
		
		private AVLtree() {
			
		}
		
		
		
	}
	
	
	
}
