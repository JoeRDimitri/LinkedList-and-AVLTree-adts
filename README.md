The restrictions of this project: 
Create two abstract data types (ADTs) of my choice that will accomodate a larger dataset and a smaller data set. The datasets is made to contain student names and unique ids, each adt should implement methods such sort;remove;add;nextkey;previouskey; ant others. Each adt should balance time and space complexity. If the adt satifies a larger database, it should implement faster sorting and searching. On the otherhand if the adt is for a smaller database it can use slower search and merge. I decided to go with a LinkedList for the smaller dataset and an AVL Tree for the larger dataset. 

Reasons for my decisions
LinkedList:
Slow search since we have to go through the whole list in the worst case; Implemented a mergeSort to get the data organized.
AVLTree :
Sorts on insertion with 4 kinds of rotation LL LR RR RL. I used Inorder traversal to search for next nodes.

Design: 
I have a LinkedList class and an AVLTree class that implement seperately each adt and its respective methods. They each have node Innerclass. There is a student class which represents a student name and its unique id. Each node is made up of a student object. There is a structure parent class which is a parent of both ADTs. The CleverSIDC class is the front end class for using the ADT in the driver. The constructure takes in a Long value to verify which ADT will be assigned to the CleverSIDC object. 
