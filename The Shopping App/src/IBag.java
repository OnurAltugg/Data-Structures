
public interface IBag<T> { /*I didn't write public boolean transferTo(IBag<T> targetBag, T item) method,
FýleIO class and Item class because ý couldn't implemented.I tried to implement them in class ShoppingApp.
and I wrote special methods for class. Onur Altuð Akça 260201060 G62
*/	
	 public boolean add(T newItem);
	 
	 public boolean isEmpty();
	 
	 public boolean isFull();
	 
	 public T removeByIndex(int index);
	 
	 public T remove();
	 
	 public T remove(T item);
	 
	 public int getItemCount();
	 
	 public int getIndexOf(T item);
	 
	 public boolean contains(T item);
	 
	 public void displayItems();

	 public void dump(); // removes all the items from the bag
	 
}
