package exercise_b;

public interface IStructure {

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
	public boolean insert(long value);

	/**
	 * Return {@code true} if {@code value} exists within the collection.
	 * 
	 * @param value the value for which to check
	 * @return {@code true} if {@code value} is contained within the 
	 * collection
	 */
	public boolean contains(long value);
	
	/**
	 * For testing purposes, returns the number of elements in the structure.
	 * 
	 * @return the number of elements in the structure.
	 */
	public int size();
	
	/**
	 * For testing purposes, returns the {@code value} at the specified index.
	 * 
	 * @param index the integer representing the index being accessed.
	 * @return the value in the structure at the specified index
	 */
	public long get(int index);
	
	/**
	 * For testing purposes, prints the first n number of values.
	 * 
	 * @param n the number of elements to display.
	 */
	public void head(int n);

	/**
	 * Instantiates the array.
	 * 
	 * Provides a Singleton-like design, such that the structure holding values
	 * can only be instantiated once. This ensures that only **one** instance
	 * variable on the heap is defined.
	 */
	public void initializeStructure();
	
}
