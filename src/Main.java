import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		 PriorityQueue<String> firstQueue= new PriorityQueue<String>(10);
		 firstQueue.add("first in priority 3", 3);
		 firstQueue.add("first in priority 5", 5);
		 firstQueue.add("priority 1", 1);
		 firstQueue.add("second in priority 1", 1);
		 firstQueue.add("was added with priority 15 should be last priority", 15);
		 firstQueue.add("was added with priority -5 should be last priority", -5);
		 System.out.println(firstQueue.contains("second in priority 1"));//should print- true
		 System.out.println(firstQueue.contains("third in1234 priority 1"));//should print- false
		
		 /**
		  * looping thorough with for each loop
		  */
		 for (String string : firstQueue) {
			System.out.println(string);
		}
		 
		 firstQueue.remove("first in priority 3");
		 firstQueue.remove("first in priority 5");
		 
		 /**
		  * looping thorough with iterator
		  */ 
		 
		 System.out.println("here");
		 Iterator<String> itr = firstQueue.iterator();
		 while(itr.hasNext()) {
			 Object element=itr.next();
			 System.out.println(element);
			 
		 }
		 System.out.println("after loop");
		}
	}

