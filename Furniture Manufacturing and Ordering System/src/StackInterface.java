
public interface StackInterface<T> { // In this interface � used getter for warehouses and used getter,setter for warehouses top_index(for stack) and � used
	                                 // them in parameter.In pop and push methods � couldn't change the warehouse's top_index therefore � called the mainmenu setter method
	                                 // so � am not changing top_indexs in push and pop methods.
	public void push(T[]warehouse , int top_index , T newEntry);
	
	public T pop(T[]warehouse , int top_index);
	
	public T peek(T[]warehouse , int top_index);
	
	public  boolean isEmpty(int top_index);
	
	public boolean isFull(int top_index);
	
	public int getProductCount(int top_index); // for main menu
	
	public boolean contains(T[]warehouse,int top_index,T product); // for isStored

}
