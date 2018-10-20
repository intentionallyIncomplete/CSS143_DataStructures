/**
 * Class Description:
 * 
 * @author Ian Bryan
 * @version 10/17/2018
 * 
 * This class serves as a template for the basic functionality found in the ArrayList
 * class supported by the Java library. Methods here represent the "hard-coded" versions 
 * of the same functionality found in the ArrayList class.
 * */

public class ArrayListLike {

	/*Data Members*/
	private Object[] listOfObjects = new Object[1];
	//private boolean emptyIndex = false;

	/*Methods*/

	//Insert an Object at some index in the array that's specified by the program.
	public void insert(Object seenItem,int index){
		if(listOfObjects[0] == null){
			listOfObjects[0] = seenItem;
		}else if(index > listOfObjects.length){
			System.out.println("Index is out of bounds");
		}else if(index <= listOfObjects.length-1){
			//Declaring the required data members local to this method
			Object[] rhs = new Object[index+1];
			Object[] lhs = new Object[listOfObjects.length-index];
			Object[] newListOfObjects = new Object[listOfObjects.length+1];
			//Copy the first section to the right, the rest to the left
			//Then replace the end of the right side with the new Object
			System.arraycopy(listOfObjects, 0, rhs, 0, rhs.length);
			System.arraycopy(listOfObjects, index, lhs, 0, lhs.length);
			rhs[rhs.length-1] = seenItem;
			//Copy the right and left into the newList which is +1 > originalList
			//Set the "old" equal to the new
			System.arraycopy(rhs, 0, newListOfObjects, 0, rhs.length);
			System.arraycopy(lhs, 0, newListOfObjects, rhs.length, lhs.length);
			listOfObjects = newListOfObjects;
		}else{
			//
			Object[] newListOfObjects = new Object[listOfObjects.length+1];
			System.arraycopy(listOfObjects, 0, newListOfObjects, 0, listOfObjects.length);
			newListOfObjects[newListOfObjects.length-1] = seenItem;
			listOfObjects = newListOfObjects;
		}	
	}

	//Remove an Object from the list of Objects
	public Object remove(int index){
		Object itemRemoved = null;
		for(int i=0;i<=index;i++){
			itemRemoved = listOfObjects[i];
			listOfObjects[i] = null;
		}
		return itemRemoved;
	}

	//Return the seen number of elements in the current list
	public int size(){
		return listOfObjects.length;
	}

	//Overriding the default toString method of System.out.print
	@Override
	public String toString(){
		String retVal = "";
		for(int i=0;i<listOfObjects.length;i++){
			retVal += listOfObjects[i] + "\n";
		}
		return retVal;
	}

	//Boolean condition module checks for empty list
//	public boolean isEmpty(){
//		for(int i=0;i<listOfObjects.length;i++){
//			if(listOfObjects[i] != null){
//				return false;
//			}
//		}
//		return true;
//	}

	//Finding the index of an Object within the list, then return that index's numerical position
	public int indexOf(Object targetObj){
		for(int i=0;i<listOfObjects.length;i++){
			if(listOfObjects[i] == ((ArrayListLike)targetObj).get(i)){
				return i;
			}else{
				System.out.print("No item found by that value");
				return -1;
			}
		}
		return -1;
	}

	//Checking for if given item matches another
	public boolean equals(Object otherObject){
		for(int i=0;i<listOfObjects.length;i++){
			if(listOfObjects[i] == otherObject){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}

	//This module will take in a target position marker,
	//and use it to return that specified Object
	public Object get(int indexOfTarget){
		return listOfObjects[indexOfTarget];
	}
}
