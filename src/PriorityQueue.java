import java.util.ArrayList;
import java.util.Iterator;
import java.lang.Iterable;
/**
 * Priority Queue Java Implementation 
 * In this Implementation the higher the number the lower the priority
 * @author BenA
 *
 * @param <E> The Data type of the data the priority queue should hold
 */

public class PriorityQueue <E> implements Iterable<E>{
	private int _amountOfPriorities;
	private int _amountOfItemsInTheQueue;
	protected ArrayList<E>[] priority;

	@SuppressWarnings("unchecked")
	/*
	 * Contructor
	 */
	public PriorityQueue(int n) {
		_amountOfPriorities=n;
		priority = new ArrayList[_amountOfPriorities];
		for (int i = 0; i < 10; i++) {
			priority[i] = new ArrayList<E>();
		}
	}

	/*
	 * This Method add a item to the Priority Queue at and the given int set as the priority queue
	 */
	public void add(E item , int n){
		if(n>0 && n<_amountOfPriorities)
			priority[n-1].add(item);
		else //if n is out of the priorities index range will insert it at the lowest priority (the higher the number the lower the priority)
			priority[_amountOfPriorities-1].add(item);
		_amountOfItemsInTheQueue++;
	}

	/*
	 * This Method removes and then returns the next number in the priority queue
	 */
	public E poll(){
		E temp;
		for (ArrayList<E> arrayList : priority) {
			if(!(arrayList.isEmpty())) {
				temp=arrayList.get(0);//gets the first item in the arrayList in the first priority that wasn't empty
				arrayList.remove(0);
				_amountOfItemsInTheQueue--;
				return temp;
			}
		}

		return null;
	}

	/*
	 * This Method checks if a given <E> item is contained inside the priority queue
	 */
	public boolean contains(E item) {
		for (ArrayList<E> arrayList : priority) {
			if(arrayList.contains(item))
				return true;
		}
		return false;
	}

	/*
	 * This Method removes the next item from the priority queue
	 */
	public boolean remove(E item) {
		for (ArrayList<E> arrayList : priority) {
			if(arrayList.contains(item)) {
				arrayList.remove(arrayList.indexOf(item));
				_amountOfItemsInTheQueue--;
				return true;
			}
		}
		return false;
	}

	/*
	 * This Method returns the size of the priority queue (the size is the amount of all item stored inside the priority queue)
	 */
	public int size() {
		return _amountOfItemsInTheQueue; 
	}

	/*
	 * Iterator Override implementation 
	 */
	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			private int indexInArrayList=0;
			private int indexOfArrayList=0;
			private int hasNextIndexOfArrayList;
			private int hasNextIndexInArrayList;
/*
 * This Method checks if there is a next item in the priority queue
 * returns true if there is a next item 
 * returns false if there is no next item
 */
			@Override
			public boolean hasNext() {
				hasNextIndexInArrayList=indexInArrayList;
				hasNextIndexOfArrayList=indexOfArrayList;
				while(hasNextIndexOfArrayList<_amountOfPriorities) {
					try{
						priority[hasNextIndexOfArrayList].get(hasNextIndexInArrayList);	
					}
					catch (IndexOutOfBoundsException e) {
						hasNextIndexOfArrayList++;
						hasNextIndexInArrayList=0;
						continue;
					}
					return true;
				}
				return false;
			}
/*
 * This Method returns the next item in the priority queue if there is a next item 
 * returns null if there is no next item
 */
			@Override
			public E next() {
				E temp;
				while(indexOfArrayList<_amountOfPriorities) {
					try{
						temp=priority[indexOfArrayList].get(indexInArrayList);	
					}
					catch (IndexOutOfBoundsException e) {
						indexOfArrayList++;
						indexInArrayList=0;
						continue;
					}
					indexInArrayList++;
					return temp;
				}
				return null;
			}


		};

	}
}
