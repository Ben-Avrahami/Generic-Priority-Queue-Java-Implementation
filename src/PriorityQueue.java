import java.util.ArrayList;
import java.util.Iterator;
import java.lang.Iterable;


public class PriorityQueue <E> implements Iterable<E>{
	private int _amountOfPriorities;
	private int _amountOfItemsInTheQueue;
	public ArrayList<E>[] priority;

	@SuppressWarnings("unchecked")
	public PriorityQueue(int n) {
		// TODO Auto-generated constructor stub
		_amountOfPriorities=n;
		priority = new ArrayList[_amountOfPriorities];
		for (int i = 0; i < 10; i++) {
			priority[i] = new ArrayList<E>();
		}

	}

	public void add(E item , int n){
		if(n>0 && n<_amountOfPriorities)
			priority[n-1].add(item);
		else 
			priority[_amountOfPriorities-1].add(item);
		_amountOfItemsInTheQueue++;
	}

	public E poll(){
		E temp;
		for (ArrayList<E> arrayList : priority) {
			if(!(arrayList.isEmpty())) {
				temp=arrayList.get(0);//gets the first item in the arrayList in the first priority that wasnt empty
				arrayList.remove(0);
				_amountOfItemsInTheQueue--;
				return temp;
			}
		}

		return null;
	}

	public boolean contains(E item) {
		for (ArrayList<E> arrayList : priority) {
			if(arrayList.contains(item))
				return true;
		}
		return false;
	}

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

	public int size() {
		return _amountOfItemsInTheQueue; 
	}



	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			private int indexInArrayList=0;
			private int indexOfArrayList=0;
			private int hasNextIndexOfArrayList;
			private int hasNextIndexInArrayList;

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
