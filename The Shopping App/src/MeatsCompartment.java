
public class MeatsCompartment<T> implements IBag<T> {
	
	private final T[] meatsbag ;
	private int default_capacity ;
	private int numberOfEntries;
	
	
	public MeatsCompartment() {
		numberOfEntries = 0;
		default_capacity = 5000;
		@SuppressWarnings("unchecked")
		T[] tempBag = (T[])new Object[10];
		meatsbag = tempBag;
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
		if(default_capacity < 500) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public  void displayCapacity(){
		System.out.println("Meats : "+default_capacity+" grams");
	}
	
	public boolean add(T newItem) {
		
		meatsbag[numberOfEntries] = newItem;
		numberOfEntries++;
		return true;
			
	}

	public boolean isEmpty() {
		
		return default_capacity == 5000;
		
	}
	public boolean isFull() {
		 
		return default_capacity == 0;
        
	}

	public T removeByIndex(int index) {
		if(isEmpty()) {
			return null;
		}
		else {
			for(int i = index ; i < numberOfEntries ; i++) {
				meatsbag[i] = meatsbag[i+1];
			}
			numberOfEntries-- ;
			return null;
		}
		
	}

	public T remove() {
		if(isEmpty()) {
			return null ;
		}
		else {
			meatsbag[numberOfEntries-1] = null;
			numberOfEntries-- ;
			return null;
		}
		
	}

	public T remove(T item) {
		if(isEmpty()) {
			return null;
		}
		else if(!contains(item)) {
			return null;
		}
		else {
			for(int i = 0 ; i < numberOfEntries ; i++) {
				if(meatsbag[i] == item) {
					int index = i;
					for(int j = index ; j < numberOfEntries ; j++) {
						meatsbag[j] = meatsbag[j+1];
					}
					numberOfEntries-- ;
					return item;
				}
			}
			return null;
		}
		
	}

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

	public int getIndexOf(T item) {
		if(!isEmpty()) {
			for(int i = 0 ; i < numberOfEntries ; i++) {
				if(meatsbag[i] == item) {
					return i ; 
				}
			}
		}
		return -1;

	}

	public boolean contains(T item) {
		if(!isEmpty()) {
			for(int i = 0; i < numberOfEntries ; i++) {
				if(meatsbag[i] == item) {
					return true ; 
				}
			}
		}
		
		return false;
	}

	public void displayItems() {
		if(!isEmpty()) {
			String combination = "";
			for(int i = 0; i < numberOfEntries-1 ; i++) {
				combination = combination + meatsbag[i] + ",";
		    }
			combination += meatsbag[numberOfEntries - 1];
			System.out.println("Meats Compartment contains: " + combination);
		}
		else {
			System.out.println("Meats Compartment contains: empty " );
		}
		
		
	}

	public void dump() {
		if(!isEmpty()) {
			for(int i = 0; i < numberOfEntries ; i++) {
				meatsbag[i] = null;
			}
			numberOfEntries = 0 ;
			default_capacity = 5000;
		}

	}
}
