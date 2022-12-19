PriorityQueue
A Java implementation of a priority queue data structure. The priority queue is implemented using an array of ArrayLists, with each ArrayList representing a priority level.

Features
Add items to the queue with a specified priority level
Remove the next item from the queue using the poll() method
Check if the queue contains a specific item using the contains() method
Remove a specific item from the queue using the remove() method
Get the current size of the queue using the size() method
Iterate through the items in the queue in priority order using the iterator() method
Example
Copy code
// Create a new priority queue with 10 priority levels
PriorityQueue<String> queue = new PriorityQueue<>(10);

// Add some items to the queue
queue.add("Low priority item", 1);
queue.add("High priority item", 10);

// Remove the next item from the queue
String item = queue.poll(); // "High priority item"

// Check if the queue contains a specific item
boolean containsItem = queue.contains("Low priority item"); // true

// Remove a specific item from the queue
queue.remove("Low priority item");

// Get the current size of the queue
int size = queue.size(); // 0

// Iterate through the items in the queue
for (String i : queue) {
    System.out.println(i);
}