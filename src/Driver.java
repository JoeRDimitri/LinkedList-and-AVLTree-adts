import java.io.BufferedReader;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Driver {

	public static void main(String[] args) {
		 File myObj = new File("64249931.txt");
		    if (myObj.exists()) {
		      System.out.println("File name: " + myObj.getName());
		      System.out.println("Absolute path: " + myObj.getAbsolutePath());
		      System.out.println("Writeable: " + myObj.canWrite());
		      System.out.println("Readable " + myObj.canRead());
		      System.out.println("File size in bytes " + myObj.length());
		    } else {
		      System.out.println("The file does not exist.");
		    }
		    
		    
		    
		    CleverSIDC adt1 = new CleverSIDC(500);
		    CleverSIDC adt2 = new CleverSIDC(10010);
		    
		
		    try {
		        Scanner myReader = new Scanner(myObj);
		        while (myReader.hasNextLine()) {
		          String data = myReader.nextLine();
//		          System.out.println(data);
		          adt1.add(data);
		          adt2.add(data);
		          
		        }
		        myReader.close();
		      } catch (FileNotFoundException e) {
		        System.out.println("An error occurred.");
		        e.printStackTrace();
		      }
		    
//			1. UNSORTED LINKED LIST
//		    
//		    a. Calling print automatically sorts the linked list using Merge Sort
//		    adt1.print();
//		    System.out.println();
		    
//		    b.Using the Remove function:
//		    adt1.remove("05716101");
		    
//		    adt1.print();
		    
		    
//		    c. Searching for specific keys. 
		    
//		    This value exists
//		  adt1.getValues("97378483");
		    
//			This one does not
//		  adt1.getValues("86148178");
//		    System.out.println(adt1.getNextKey("86148178"));
		    
//		    d. Getting next key
//		    adt1.nextKey("07017029");
//		    adt1.nextKey("97378483");
		    
		    
		    
//		    e. getPrevious 
//		    adt1.getPrevious("05716101");
		    
//		    d. Range Key
//		    adt1.range("70188256", "97378483");

		    
		    
		    
		    
		    
		    
		    //		    AVLTREE
		    //print avltree
		    adt2.print();
		    System.out.println();
		    System.out.println();

		    //remove
//		  adt2.remove("84629786");
//		  System.out.println();
//		    System.out.println();

//		    adt2.print();
//		    NextNode
//		    doesnt work for last node
//		    adt2.nextKey("72613054");
		    

		    
	
	
	//"C:\Users\pc02\OneDrive\Bureau\test\64249931.txt"

	/*
	 * multiple lists of n students 
	 * each student has a key of unique 8 digit code called StudentIDentificationCode
	 * 
	 * student tracking ADT called CeverSIDC
	 * - retrieve key value pairs
	 * - access a single element by its key
	 * - can access neighbours (predecessor/successor)
	 * 
	 * operations to a single CleverSIDC cant be worse than O(n)
	 * 
	 * complete Clever SIDC should not exceed O(n^2)
	 * 
	 * 
	 * Dynamic content 
	 * 
	 * 
	 * 	parameters: 
	 * 		1. number of students (n) 
	 * 		2. 8 digit SIDC(key)
	 * 		3.
	 * 
	 * 
	 * AVLtree class (with inner node class)
	 * LinkedList class (with inner node class)
	 * 
	 * implement their methods in the CleverSIDC class
	 * 
	 * 
	 */
}
	}
