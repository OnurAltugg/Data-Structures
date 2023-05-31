
public class SnacksCompartment<T> implements IBag<T>{
	
	private final T[] snacksbag ;
	private int default_capacity ;
	private int numberOfEntries;
	
	public SnacksCompartment() {
		numberOfEntries = 0;
		default_capacity = 2000;
		@SuppressWarnings("unchecked")
		T[] tempBag = (T[])new Object[8];
		snacksbag = tempBag;
	}
	
	public boolean decreaseCapacity(int decreasecapacity) {
		if(default_capacity - decreasecapacity >= 0) {
			default_capacity -= decreasecapacity;
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public void increaseCapacity(int increasecapacity) {
		default_capacity += increasecapacity;
	}
	
	public  boolean checkCapacity(){
		if(default_capacity < 250) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public  void displayCapacity(){
		System.out.println("Snacks : "+default_capacity+" grams");
	}

	@Override
	public boolean add(T newItem) {
		
		snacksbag[numberOfEntries] = newItem;
		numberOfEntries++;
		return true;
		
	}

	@Override
	public boolean isEmpty() {
		return default_capacity == 2000;
	}

	@Override
	public boolean isFull() {
		return default_capacity == 0;
	}

	@Override
	public T removeByIndex(int index) {
		if(isFull()) {
			return null;
		}
		else {
			for(int i = index ; i < numberOfEntries ; i++) {
				snacksbag[i] = snacksbag[i+1];
			}
			numberOfEntries-- ;
			return null;
		}
	}

	@Override
	public T remove() {
		if(isFull()) {
			return null ;
		}
		else {
			snacksbag[numberOfEntries-1] = null;
			numberOfEntries-- ;
			return null;
		}
	}

	@Override
	public T remove(T item) {
		if(isFull()) {
			return null;
		}
		else if(!contains(item)) {
			return null;
		}
		else {
			for(int i = 0 ; i < numberOfEntries ; i++) {
				if(snacksbag[i] == item) {
					int index = i;
					for(int j = index ; j < numberOfEntries ; j++) {
						snacksbag[j] = snacksbag[j+1];
					}
					numberOfEntries-- ;
					return item;
				}
			}
			return null;
		}
	}

	@Override
	public int getItemCount() {
		if(!isEmpty()) {
			int counter = 0;
			for(int i = 0 ; i < numberOfEntries ; i++) {
					counter++ ; 
				
			}
			return counter;
		}
		return -1;
	}

	@Override
	public int getIndexOf(T item) {
		if(!isEmpty()) {
			for(int i = 0 ; i < numberOfEntries ; i++) {
				if(snacksbag[i] == item) {
					return i ; 
				}
			}
		}
		
		return -1;
	}

	@Override
	public boolean contains(T item) {
		if(!isEmpty()) {
			for(int i = 0; i < numberOfEntries ; i++) {
				if(snacksbag[i] == item) {
					return true ; 
				}
			}
		}
		
		return false;
	}

	@Override
	public void displayItems() {
		if(!isEmpty()) {
			String combination = "";
			for(int i = 0; i < numberOfEntries-1 ; i++) {
				combination = combination + snacksbag[i] + ",";
		    }
			combination += snacksbag[numberOfEntries - 1];
			System.out.println("Snacks Compartment contains: " + combination);
		}
		else {
			System.out.println("Snacks Compartment contains: empty ");
		}
		
		
	}

	@Override
	public void dump() {
		if(!isEmpty()) {
			for(int i = 0; i < numberOfEntries ; i++) {
				snacksbag[i] = null;
			}
			numberOfEntries = 0 ;
			default_capacity = 2000;
		}
	}

}
