package exercise_a;

import java.util.ArrayList;
import java.util.Collection;

/**
 * An extension of Thread that keeps track of counts that it is observed.
 * 
 * @author Aditya Srinivasan
 *
 */
public class CounterThread extends Thread {
	
	private String name;
	private Collection<Integer> myCounts;
	
	/**
	 * Instantiates the thread and list of counts.
	 * @param runnable
	 * @param name
	 */
	public CounterThread(Runnable runnable, String name) {
		super(runnable, name);
		this.name = name;
		myCounts = new ArrayList<>();
	}
	
	/**
	 * Adds an integer to its list of counts.
	 * 
	 * @param i
	 */
	void addToCounts(Integer i) {
		myCounts.add(new Integer(i));
	}

	/**
	 * Displays the contents of the list of counts.
	 */
	void displayContents() {
		System.out.println(name + ": " + myCounts);
	}
	
	/**
	 * Returns the list of counts.
	 * @return
	 */
	Collection<Integer> getCounts() {
		return myCounts;
	}

}
