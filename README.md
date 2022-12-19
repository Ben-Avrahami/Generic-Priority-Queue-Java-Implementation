<h1>PriorityQueue</h1>

<p>A Java implementation of a priority queue data structure. The priority queue is implemented using an array of ArrayLists, with each ArrayList representing a priority level.</p>

<h2>Features</h2>

<ul>
  <li>Add items to the queue with a specified priority level</li>
  <li>Remove the next item from the queue using the <code>poll()</code> method</li>
  <li>Check if the queue contains a specific item using the <code>contains()</code> method</li>
  <li>Remove a specific item from the queue using the <code>remove()</code> method</li>
  <li>Get the current size of the queue using the <code>size()</code> method</li>
  <li>Iterate through the items in the queue in priority order using the <code>iterator()</code> method</li>
</ul>

<h2>Example</h2>

<pre>
<code>
// Create a new priority queue with 10 priority levels
PriorityQueue&lt;String&gt; queue = new PriorityQueue&lt;&gt;(10);

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
</code>
</pre>
