import java.util.Iterator;

public class ClientRequestsMain {
	public static void main(String[] args) {
		System.out.println("Testing with ClientRequests priority Queue:\n");
		// Create a PriorityQueue with 10 priorities
		PriorityQueue<ClientRequests> queue = new PriorityQueue<>(10);

		// Add some client requests to the queue with various priorities
		queue.add(new ClientRequests("John", 123456789), 1);
		queue.add(new ClientRequests("Jane", 987654321), 2);
		queue.add(new ClientRequests("Bob", 111111111), 3);
		queue.add(new ClientRequests("Alice", 222222222), 4);
		queue.add(new ClientRequests("Alona", 555555555), 8);
		queue.add(new ClientRequests("Liron", 135794745), 12);//should be on priority 10
		queue.add(new ClientRequests("Yarden", 256175683), -2);//should be on priority 10

		// Check the size of the queue
		System.out.println("Queue size: " + queue.size());
		
		// Check if the queue contains a specific client request
		System.out.println("Checking if Queue contains John's request: " + queue.contains(new ClientRequests("John", 123456789)));//should return true
		System.out.println("Checking if Queue contains Alice with different then given id request: " + queue.contains(new ClientRequests("Alice", 225222222)));//should return false
		// Remove a specific client request from the queue
		queue.remove(new ClientRequests("Jane", 987654321));

		// Poll the next item from the queue
		ClientRequests nextItem = queue.poll();
		System.out.println("Next item in queue: " + nextItem.getName() + " - " + nextItem.getId());

		// Use an iterator to iterate through all the items in the queue
		Iterator<ClientRequests> iterator = queue.iterator();
		while (iterator.hasNext()) {
			ClientRequests item = iterator.next();
			System.out.println(item.getName() + " - " + item.getId());
		}
	}
}
