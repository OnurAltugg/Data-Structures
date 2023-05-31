
public class ShoppingBasket<T> implements IBag<T> {
	
	private final T[] shoppingbasket ;
	private int default_capacity ;
	private int numberOfEntries;
	
	public ShoppingBasket() {
		numberOfEntries = 0;
		default_capacity = 2000;
		@SuppressWarnings("unchecked")
		T[] tempBag = (T[])new Object[8];//I choose the length of the string according to the
		shoppingbasket = tempBag; //probability of which item will put the most.Like the worst case.
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
		
	public  boolean checkCapacity(){ // "You cannot add any more items to the basket" for this.
		if(default_capacity < 250) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public <array> String[] copyarray() { // public boolean transferTo(IBag<T> targetBag, T item)
		                                  // I wrote instead of this method.
		                                  //and I tried to do the transfer in ShoppingApp class
		String[] copy_array = new String [numberOfEntries];
		for(int i = 0 ; i < numberOfEntries ; i++) {
			copy_array[i] = (String) shoppingbasket[i];
		}
		return copy_array;
		
	}
	
	public boolean add(T newItem) { // I didn't write precondition because decreaseCapacity method checks 
		                             // in the Shopping App class.
		shoppingbasket[numberOfEntries] = newItem;
		numberOfEntries++;
		return true;

	}

	@Override
	public boolean isEmpty() {
		return default_capacity == 2000; //Since I don't know which items of the array are null
	}                                    // I made this check on capacity.

	@Override
	public boolean isFull() {
		return default_capacity == 0;
	}

	@Override
	public T removeByIndex(int index) {
		if(isEmpty()) {
			return null;
		}
		else {
			for(int i = index ; i < numberOfEntries ; i++) {
				shoppingbasket[i] = shoppingbasket[i+1];
			}
			numberOfEntries-- ;
			return null;
		}
	}

	@Override
	public T remove() {
		if(isEmpty()) {
			return null ;
		}
		else {
			shoppingbasket[numberOfEntries-1] = null;
			numberOfEntries-- ;
			return null;
		}
	}

	@Override
	public T remove(T item) {
		if(isEmpty()) {
			return null;
		}
		else if(!contains(item)) {
			return null;
		}
		else {
			for(int i = 0 ; i < numberOfEntries ; i++) {
				if(shoppingbasket[i] == item) {
					int index = i;
					for(int j = index ; j < numberOfEntries ; j++) {
						shoppingbasket[j] = shoppingbasket[j+1];
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
				if(shoppingbasket[i] == item) {
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
				if(shoppingbasket[i] == item) {
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
				combination = combination + shoppingbasket[i] + ",";
		    }
			combination += shoppingbasket[numberOfEntries - 1];
			System.out.println("Basket contains: " + combination);
		}
		else {
			System.out.println("Basket contains: empty " );
		}
		
	}

	@Override
	public void dump() {
		if(!isEmpty()) {
			for(int i = 0; i < numberOfEntries ; i++) {
				shoppingbasket[i] = null;
			}
			numberOfEntries = 0 ;
			default_capacity = 2000;
		}
	}

}
