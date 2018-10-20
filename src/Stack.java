/**
 * Class Description:
 * @author Ian Bryan
 * @version 10/19/2018
 * 
 * This is a class that represents the implementation of a Stack
 * interface. 
 * */
public class Stack {

	/* 
	 * Data Members
	 * The private object array is designed to act as a list of "layers"
	 * that are added in order from bottom-to-top (L.I.F.O)
	 * */
	private Object[] stackArr = new Object[10];
	private int top = 0;
	private int numOfLayers;
	private boolean emptyLayer = false;

	//Objects pushed onto/into stack are added on top of the previous layer
	//Statement will first check if space is available, if not then let the user know it's full.
	public void push(Object aLayer){
		if(top + 1 < numOfLayers){
			top++;
			stackArr[top] = aLayer;
			System.out.println("the layer: " + aLayer + " was pushed successfully");
		} else {System.out.println("stack full");}
		//resize
	}

	//Similar to peek() but instead returns the object
	//and then __removes__ that layer. 
	public Object pop(){
		if(top >= 0){
			//As long as top is a valid integer between 0-infinity
			//then return (pop) the value of what is removed from the top most layer.
			System.out.println("the layer: " + stackArr[top] + 
					" has been removed successfully");
			return stackArr[top--];
		} else {

			System.out.println("no layers, stack is empty");

			return "-1";
		}
	}

	//Similar to ppop() but does not manipulate the layer
	//in order for the user to see the item at the position
	public Object peek(){
		System.out.println("top layer: " + stackArr[top]);
		return stackArr[top];
	}

	//Simple display method that is handy for when 
	//we need to show the entire stack rather than one layer at a time.
	//Used mostly for when the stack is full or when many items are pushed and 
	//the stack needs to be checked.
	public void show(){
		for(Object i : stackArr){
			System.out.println(i + " ");
		}
	}

	//(Typecasting required)
	//If some attributes about each stack are the same
	//then they must be equal. 
	public boolean equal(Object that){
		if(this.numOfLayers == ((Stack)that).numOfLayers 
				&& this.stackArr == ((Stack)that).stackArr){
			return true;
		}else{
			return false;
		}
	}
	
	//Similar to the isEmpty() method in ArrayListLike
	//this will iterate over the list of Objects
	//in the stack and check if any ordinal are empty
	public boolean isEmpty(){
		for(int i=0;i<stackArr.length;i++){
			if(stackArr[i] == null){
				emptyLayer = true;
			}else{
				emptyLayer = false;
			}
		}
		return emptyLayer;
	}
	
	//Grab the size of the stack
	public int size(){
		return stackArr.length;
	}

	//Similar to the `String retVal = "";` method,
	//StringBuilder here simply builds a String from the
	//items layered in the stack as they are iterated through
	public String toString(){
		StringBuilder sb = new StringBuilder();

		while(stackArr[top] != null){
			sb.append(" ").append(stackArr[top]);
		}
		return sb.toString();
	}
}
