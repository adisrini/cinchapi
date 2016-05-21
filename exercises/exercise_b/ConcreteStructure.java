package exercise_b;

/**
 * This class implements the specified structure interface to provide the desired interface. The implementation
 * uses an array of long values, of capacity 16,000,000. Since each long is 4 bytes in size, this allows for
 * a maximum of 64MB of storage on the heap, and satisfies a minimum number of 10,000,000 values to be stored.
 * 
 * The class is well-encapsulated as it only exposes the methods specified in its interface. No variables are
 * exposed, ensuring that they cannot be modified unwantedly.
 * 
 * @author Aditya Srinivasan
 *
 */
public class ConcreteStructure implements IStructure {
	
	/**
	 * The maximum capacity of the structure, which allows for 64MB of space to be allocated on the heap.
	 */
	private static final int CAPACITY = 16000000;
	
	private long[] values;
	private int index;
	
	/**
	 * Instantiates the array.
	 *
	 * Provides a Singleton-like design, such that the structure holding values
	 * can only be instantiated once. This ensures that only **one** instance
	 * variable on the heap is defined.
	 */
	@Override
	public void initializeStructure() {
		if(values == null) {
			values = new long[CAPACITY];
			index = 0;
		}
	}

	/**
	 * Attempt to insert {@code value} into the collection and return 
	 * {@code true} if the collection is modified after this method
	 * returns (e.g. {@code value} was not already contained in the
	 * collection)
	 * 
	 * @param value a long value to insert into the collection
	 * @return {@code true} if {@code value} didn't previously exist in
	 * the collection and is inserted
	 */
	@Override
	public boolean insert(long value) {
		if(index < CAPACITY && !contains(value)) {
			values[index++] = value;
			return true;
		}
		return false;
	}

	/**
	 * Return {@code true} if {@code value} exists within the collection.
	 * 
	 * @param value the value for which to check
	 * @return {@code true} if {@code value} is contained within the 
	 * collection
	 */
	@Override
	public boolean contains(long value) {
		for(long v : values) {
			if(v == value) {
				return true;
			}
		}
		return false;
	}

	/**************************************
	  ** BELOW: Methods for testing purposes
	   **************************************/
	
	/**
	 * For testing purposes, prints the first n number of values.
	 * 
	 * @param n the number of elements to display.
	 */
	@Override
	public void head(int n) {
		System.out.print("VALUES: ");
		for(int i = 0; i < n; i++) {
			System.out.print(values[i] + " ");
		}
		System.out.println();
	}
	
	/**
	 * For testing purposes, returns the number of elements in the structure.
	 * 
	 * @return the number of elements in the structure.
	 */
	@Override
	public int size() {
		return index;
	}

	/**
	 * For testing purposes, returns the {@code value} at the specified index.
	 * 
	 * @param index the integer representing the index being accessed.
	 * @return the value in the structure at the specified index
	 */
	@Override
	public long get(int index) {
		return values[index];
	}

}
