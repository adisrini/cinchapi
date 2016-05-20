package exercise_a;

public class CounterThread extends Thread {
	
	public CounterThread(Runnable runnable, String threadName) {
		super(runnable, threadName);
	}

}
