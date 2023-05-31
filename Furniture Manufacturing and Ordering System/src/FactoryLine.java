
public class FactoryLine<T> implements QueueInterface<T>  {
	
	private final T[] factoryline;
	private int front;
	private int rear;
	private int numberOfEntries;
	private int capacity;
	
	public FactoryLine(int size) {
		
		@SuppressWarnings("unchecked")
		T[] tempfactoryline = (T[])new Object[size];
		factoryline = tempfactoryline;
		numberOfEntries = 0;
		front = 0;
		rear = -1;
		capacity = size;
				
	}
	

	@Override
	public void enqueue(T newEntry) {
		if (!isFull()) {
			rear = (rear + 1) % capacity;
			factoryline[rear] = newEntry;
			numberOfEntries++;
		}	
		
	}

	@Override
	public void  dequeue() {
		
		if(!isEmpty()){
		    factoryline[front] = null;
			front = (front + 1) % capacity;
			numberOfEntries--;

		}

		
	}

	@Override
	public T getFront() {

		return factoryline[front];
	}

	@Override
	public boolean isEmpty() {
		
		return numberOfEntries == 0 ;
		
	}


	@Override
	public int getProductCount(T product) {
		
		int counter = 0;
		if(rear == -1) {
			return 0 ;
		}
		else {
			for(int i = front ; i <= rear ; i++) {
				if(factoryline[i] == product) {
					counter++ ;
				}
		}
		return counter;
		}
		
		
	}


	@Override
	public boolean isFull() {
		
		return  numberOfEntries == (capacity - 1) ;
		
	}


	@Override
	public boolean contains(T product) {

		return factoryline[front] == product;
		 
	}
	
	

}
