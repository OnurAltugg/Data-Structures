
public class SoldProducts<T> {
	
	private final T[] soldproducts ;
	
	private int numberOfEntries;
	
	@SuppressWarnings("unchecked")
	public SoldProducts(int size) {
		T[] tempsoldproducts = (T[])new Object[size];
		soldproducts = tempsoldproducts;
		numberOfEntries = 0;
	}
	
	public boolean contains(T product) {
		for(int i = 0; i < numberOfEntries ; i++) {
			if(soldproducts[i] == product) {
				return true ; 
			}
		}
		return false;
	}
	
    public void add(T newProduct) {
    	soldproducts[numberOfEntries] = newProduct;
		numberOfEntries++;		
	}
    
    public int getProductCount(T product) {
    	int counter = 0;
		for(int i = 0 ; i < numberOfEntries ; i++) {
				if(soldproducts[i] == product) {
					counter++ ;
				}
		}
		return counter;
    }
	
	
	
	

}
