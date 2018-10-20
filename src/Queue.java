/**
 * Class Description:
 * @author Ian Bryan
 * @version 10/19/2018
 * 
 * This class represents the implementation of a Queue type class
 * */
public class Queue {

	/*
	 * 
    void enqueue(Object)
    Object dequeue()
    int size()
    String toString()
    boolean isEmpty()
    boolean equals(Object)
	 */

	/*Data Members*/
	private Object[] queueArr = new Object[1];
	private int next;
	private int numQueues = 0;
	private int last = 0;
	private int queueSize;

	//Similar to the Stack interface if the number of queues
	//+1 is less than the size, then a space is available
	//and place the new item in that space.
	public void enqueue(Object nextQueue){
		if(numQueues + 1 < queueSize){
			queueArr[last] = nextQueue;
			last++;
			numQueues++;
			System.out.println("the item: " + queueArr[last] + " was added successfully");
		} else {
			//resize();
			System.out.println("queue full");
		}
	}

	//Return the latest item(s) in FIFO format
	public Object dequeue(){
			next++;
			numQueues--;
			return queueArr[next];
	}

	//Return the object that occupies the current space
	//without actually manipulating the list
	public Object peek(){
		return queueArr[next];
	}

	public boolean equal(Object that){
		if(this.numQueues == ((Queue)that).numQueues
				&& this.queueArr == ((Queue)that).queueArr){
			return true;
		}else{
			return false;
		}
	}

	//Grab the size, then return it.
	public int size(){
		return queueArr.length;
	}
	
	//Check for if any spots are null, and if so then that space is empty.
	public boolean isEmpty(){
		for(int i=0;i<queueArr.length;i++){
			if(queueArr[i] == null){
				return true;
			}
		}
		return false;
	}
	
	//Build a string from all the objects
	public String toString(){
		StringBuilder sb = new StringBuilder();

		while(queueArr[next] != null){
			sb.append(" ").append(queueArr[next]);
		}
		return sb.toString();
	}
}
