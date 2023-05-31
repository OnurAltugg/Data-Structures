
public interface QueueInterface<T> {
	
	public void enqueue(T newEntry);
	
	public void  dequeue();
	
	public T getFront();
	
	public boolean isEmpty();
	
	public boolean isFull();
	
	public int getProductCount(T product); // for main menu
	
	public boolean contains(T product); // for isManufactured
}
