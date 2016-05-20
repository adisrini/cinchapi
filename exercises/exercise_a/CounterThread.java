package exercise_a;

import java.util.ArrayList;
import java.util.Collection;

public class CounterThread extends Thread {
	
	private String name;
	private Collection<Integer> myCounts;
	
	public CounterThread(Runnable runnable, String name) {
		super(runnable, name);
		this.name = name;
		myCounts = new ArrayList<>();
	}
	
	void addToCounts(Integer i) {
		myCounts.add(new Integer(i));
	}

	public void displayContents() {
		System.out.println(name + ": " + myCounts);
	}

}
