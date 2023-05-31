import java.util.EmptyStackException;

public class Warehouses<T> implements StackInterface<T> {
	
	private final T[] sofa_warehouse;
	private final T[] bed_warehouse;
	private final T[] chair_warehouse;
	private final T[] dresser_warehouse;
	private final T[] table_warehouse;
	private final T[] bookcase_warehouse;
	private int top_sofa_warehouse;
	private int top_bed_warehouse;
	private int top_chair_warehouse;
	private int top_dresser_warehouse;
	private int top_table_warehouse;
	private int top_bookcase_warehouse;
	private int capacity;
	
    @SuppressWarnings("unchecked")
	public Warehouses(int size) {
		
		T[] temp_sofa_warehouse = (T[])new Object[size];
		sofa_warehouse = temp_sofa_warehouse;
		T[] temp_bed_warehouse = (T[])new Object[size];
		bed_warehouse = temp_bed_warehouse;
		T[] temp_chair_warehouse = (T[])new Object[size];
		chair_warehouse = temp_chair_warehouse;
		T[] temp_dresser_warehouse = (T[])new Object[size];
		dresser_warehouse = temp_dresser_warehouse;
		T[] temp_table_warehouse = (T[])new Object[size];
		table_warehouse = temp_table_warehouse;
		T[] temp_bookcase_warehouse = (T[])new Object[size];
		bookcase_warehouse = temp_bookcase_warehouse;
		this.top_sofa_warehouse = -1;
		top_bed_warehouse = -1;
		top_chair_warehouse = -1;
		top_dresser_warehouse = -1;
		top_table_warehouse = -1;
		top_bookcase_warehouse = -1;
		capacity = size ;
				
	}

	public T[] getSofa_warehouse() {
		return sofa_warehouse;
	}

	public T[] getBed_warehouse() {
		return bed_warehouse;
	}

	public T[] getChair_warehouse() {
		return chair_warehouse;
	}

	public T[] getDresser_warehouse() {
		return dresser_warehouse;
	}

	public T[] getTable_warehouse() {
		return table_warehouse;
	}

	public T[] getBookcase_warehouse() {
		return bookcase_warehouse;
	}

	public int getTop_sofa_warehouse() {
		return top_sofa_warehouse;
	}

	public int getTop_bed_warehouse() {
		return top_bed_warehouse;
	}

	public int getTop_chair_warehouse() {
		return top_chair_warehouse;
	}

	public int getTop_dresser_warehouse() {
		return top_dresser_warehouse;
	}

	public int getTop_table_warehouse() {
		return top_table_warehouse;
	}

	public int getTop_bookcase_warehouse() {
		return top_bookcase_warehouse;
	}
	
	

	public void setTop_sofa_warehouse(int top_sofa_warehouse) {
		this.top_sofa_warehouse = top_sofa_warehouse;
	}

	public void setTop_bed_warehouse(int top_bed_warehouse) {
		this.top_bed_warehouse = top_bed_warehouse;
	}

	public void setTop_chair_warehouse(int top_chair_warehouse) {
		this.top_chair_warehouse = top_chair_warehouse;
	}

	public void setTop_dresser_warehouse(int top_dresser_warehouse) {
		this.top_dresser_warehouse = top_dresser_warehouse;
	}

	public void setTop_table_warehouse(int top_table_warehouse) {
		this.top_table_warehouse = top_table_warehouse;
	}

	public void setTop_bookcase_warehouse(int top_bookcase_warehouse) {
		this.top_bookcase_warehouse = top_bookcase_warehouse;
	}

	@Override
	public void push(T[] warehouse, int top_index, T newEntry) {
		if(!isFull(top_index)) {
			warehouse[top_index + 1] = newEntry;
			//top_index++ ; changed in the main menu
		}
	}


	@Override
	public T pop(T[] warehouse, int top_index) {
		if(isEmpty(top_index)) {
			throw new EmptyStackException();
		}
		else {
			T top = warehouse[top_index];
			warehouse[top_index] = null ;
			//top_index--;  changed in the main menu
			return top;
		}
	}

	@Override
	public T peek(T[] warehouse, int top_index) {
		if(isEmpty(top_index)) {
			throw new EmptyStackException();
		}
		else {
			return warehouse[top_index];
		}
	}

	@Override
	public boolean isEmpty(int top_index) {
		return top_index == -1 ;
	}

	@Override
	public boolean isFull(int top_index) {
		return top_index == (capacity-1) ;
	}

	@Override
	public int getProductCount(int top_index) {
		return top_index + 1;
	}

	@Override
	public boolean contains(T[] warehouse, int top_index, T product) {
		if(isEmpty( top_index)) {
			return false;
		}
		for(int i = 0; i <= top_index ; i++) {
			if(warehouse[i] == product) {
				return true ; 
			}
		}
		return false;
	}
	

	
	



}
