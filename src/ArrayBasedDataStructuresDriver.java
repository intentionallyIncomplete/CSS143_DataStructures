/**
 *  Incomplete Driver for ArrayList(ObjectList), Stack and Queue
 * 
 * @author Ian Bryan
 * @version 10/17/2018
 * 
 * This "Driver" class file is used to test the individual functionality 
 * of each of the following classes: ArrayListLike, StackList, QueueLike
 */

public class ArrayBasedDataStructuresDriver {

	public static void main(String[] args) {
		//stackTests();
		queueTests();
		///arrayListTests();
	}

	private static void arrayListTests() {
		ArrayListLike a = new ArrayListLike();
		ArrayListLike b = new ArrayListLike();
		//Add some items
		a.insert('A', 0);
		a.insert('B',1);
		a.insert('C',2);
		a.insert('D', 3);
		a.insert('E', 4);
		a.insert('x',2); //Will insert at the position and move everything over
		a.insert('X',4);
		//Remove some items
		a.remove(1);
		
		b.insert('C',0);
		b.insert('D', 1);
		b.insert('E', 2);
		System.out.println("A is equal to B: " + a.equals(b));
		System.out.println("A is empty: " + a.isEmpty());
		System.out.println("index of C: " + a.indexOf('C'));
		System.out.println("size() of a: " + a.size() + ", and b: " + b.size());
		System.out.println("Getting index of 'c' using get(): " + a.get(2));
		System.out.println(a.toString());
	}

	private static void queueTests() {
		//todo: make more tests here
		Queue a = new Queue();
		
		a.enqueue('B');
		a.enqueue('a');
		a.enqueue('t');
		
		System.out.println(a.toString());
		
		while(a.isEmpty() == false) {
			System.out.println(a.dequeue());
		}

	}

	private static void stackTests() {
		//todo: make more tests here
		Stack a = new Stack();
		
		a.push('B');
		a.push('a');
		a.push('t');
		
		System.out.println(a.toString());
		
		while(a.isEmpty() == false) {
			System.out.println(a.pop());
		}
	}
}
