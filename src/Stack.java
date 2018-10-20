import java.util.Arrays;

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
	private Object[] stack = new Object[1];
	private int top = 0;

	//If the stack is empty, add the new Object to the only available position
	//If the stack has other values, add it as the top layer
	public void push(Object aLayer){
		if(stack.length == 0){
			stack[0] = aLayer;
		}else{
			Object[] newListOfObjects = new Object[stack.length+1];
			System.arraycopy(stack, 0, newListOfObjects, 0, stack.length);
			newListOfObjects[newListOfObjects.length-1] = aLayer;
			stack = newListOfObjects;
		}
	}

	//Similar to peek() but instead returns the object
	//and then __removes__ that layer. 
	public Object pop(){
		Object poppedItem = stack[top--];
		Object[] newListOfObjects = Arrays.copyOf(stack, stack.length-1);
		stack = newListOfObjects;
		return poppedItem;
	}

	//Similar to ppop() but does not manipulate the layer
	//in order for the user to see the item at the position
	public Object peek(){
		System.out.println("top layer: " + stack[top]);
		return stack[top];
	}

	//Simple display method that is handy for when 
	//we need to show the entire stack rather than one layer at a time.
	//Used mostly for when the stack is full or when many items are pushed and 
	//the stack needs to be checked.
	public void show(){
		for(Object i : stack){
			System.out.println(i + " ");
		}
	}

	//(Typecasting required)
	//If some attributes about each stack are the same
	//then they must be equal. 
	public boolean equal(Object that){
		boolean areEqual = true;
		for(int i=0;i<stack.length;i++){
			if(stack[i] != ((Queue)that).get(i)){
				areEqual = false;
			}
		}
		return areEqual;
	}

	//Similar to the isEmpty() method in ArrayListLike
	//this will iterate over the list of Objects
	//in the stack and check if any ordinal are empty
	public boolean isEmpty(){
		boolean emptyList = true;
		for(int i=0;i<stack.length;i++){
			if(stack[i] != null){
				emptyList = false;
			}
		}
		return emptyList;
	}

	//Grab the size of the stack
	public int size(){
		return stack.length;
	}

	//Similar to the `String retVal = "";` method,
	//StringBuilder here simply builds a String from the
	//items layered in the stack as they are iterated through
	public String toString(){
		String retVal = "";
		for(int i=0;i<stack.length;i++){
			retVal += stack[i] + "\n";
		}
		return retVal;
	}
}
