import java.util.Iterator;
/**
 * main which will test the different functions of the PriorityQueue with String as the data type of the PriorityQueue
 * @author BenA
 *
 */
public class Main {

	public static void main(String[] args) {
		// Create a PriorityQueue with 10 priorities
		System.out.println("Testing with String priority Queue:\n");
		PriorityQueue<String> pq = new PriorityQueue<>(10);

		// Test the add method
		pq.add("item1", 1);
		pq.add("item1.1", 1);
		pq.add("item1.2", 1);
		pq.add("item2", 2);
		pq.add("item3", 3);
		pq.add("item4", 4);
		pq.add("item4.1", 4);
		pq.add("item5", 5);
		pq.add("item6", 6);
		pq.add("item7", 7);
		pq.add("item8", 8);
		pq.add("item9", 9);
		pq.add("item10", 10);
		pq.add("item11", 11); // should be added to the last priority
		pq.add("item-5", -5); // should be added to the last priority


		// Test the poll method
		System.out.println(pq.poll()); // should print "item1"
		System.out.println(pq.poll()); // should print "item2"
		System.out.println(pq.poll()); // should print "item3"

		// Test the contains method
		System.out.println(pq.contains("item4")); // should print "true"
		System.out.println(pq.contains("item11")); // should print "true"
		System.out.println(pq.contains("item12")); // should print "false"
		System.out.println(pq.contains("item1.1")); // should print "false" item was deleted with poll
		System.out.println(pq.contains("item4.1")); // should print "true"

		// Test the remove method
		System.out.println(pq.remove("item4")); // should print "true"
		System.out.println(pq.remove("item12")); // should print "false"

		// Test the size method
		System.out.println(pq.size()); 

		//Testing the for each loop		 
		for (String string : pq) {
			System.out.println(string);
		}

		// Test the iterator
		Iterator<String> it = pq.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	} 
}


