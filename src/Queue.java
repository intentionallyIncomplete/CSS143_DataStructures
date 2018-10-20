/**
 * Class Description:
 * @author Ian Bryan
 * @version 10/19/2018
 * 
 * This class represents the implementation of a Queue type class
 * */
public class Queue {

	/*Data Members*/
	private Object[] queue = new Object[1];
	private int head, tail;

	//A new list is made with size+1 of the previous
	//Then, copy the "old" list to the new one and add the new
	//object at the end (len-1)
	public void enqueue(Object next) 
	{
		if(queue[0] == null){
			queue[0] = next;
		}else{
			Object[] newQueue = new Object[queue.length+1];
			System.arraycopy(queue, 0, newQueue, 0, queue.length);
			newQueue[newQueue.length-1] = next;
			queue = newQueue;
		}
	} 

	//Store the object at the requested index, then override it with a null value.
	//Everything is copied over to new array, then old is set to new
	public Object dequeue()
	{	
		Object frontItem = queue[head];
		queue[head] = null;
		Object[] newQueue = new Object[queue.length+1];
		System.arraycopy(queue, 0, newQueue, 1, queue.length);
		queue = newQueue;
		return frontItem;
	}

	//Return the object that occupies the current space
	//without actually manipulating the list
	public Object peek(){
		return queue[head];
	}

	public boolean equals(Object that){
		boolean areEqual = true;
		for(int i=0;i<queue.length;i++){
			if(queue[i] != ((Queue)that).get(i)){
				areEqual = false;
			}
		}
		return areEqual;
	}

	//Returning an object at the requested index position
	public Object get(int index){
		return queue[index];
	}

	//Grab the size, then return it.
	public int size(){
		return queue.length;
	}

	//Checking the condition that the length
	//does not equal zero and all positions have a value
	public boolean isEmpty(){
		boolean isNullList = false;
		for(int i=0;i<queue.length;i++){
			if(queue[i] != null){
				isNullList = false;
			}else{
				isNullList = true;
			}
		}
		return isNullList;
	}

	//Build a string from all the objects
	@Override
	public String toString(){
		String retVal = "";
		for(int i=0;i<queue.length;i++){
			retVal += queue[i] + "\n";
		}
		return retVal;
	}
}
