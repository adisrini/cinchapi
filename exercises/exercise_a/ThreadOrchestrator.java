package exercise_a;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadOrchestrator implements Runnable {

	private static final String THREAD_PROPERTIES_FILE_NAME = "threads.txt";
	private static final String DELIMITER = "\n";

	private Collection<Thread> threads;
	private AtomicInteger counter;
	private ReentrantLock lock;

	public ThreadOrchestrator() {
		lock = new ReentrantLock(true);
		counter = new AtomicInteger(0);
	}

	void initializeThreads() {
		readThreadsToList();
		threads.forEach(Thread::start);
	}
	
	private void readThreadsToList() {
		threads = new ArrayList<>();
		InputStream input = this.getClass().getResourceAsStream(THREAD_PROPERTIES_FILE_NAME);
		try (Scanner reader = new Scanner(input)) {
			reader.useDelimiter(DELIMITER);
			while (reader.hasNext()) {
				threads.add(new CounterThread(this, reader.next()));
			}
			reader.close();
		} catch (Exception e) {
			throw e;
		}
	}

	private void incrementCounter() {
		lock.lock();
		try {
			if (isCounting()) {
				System.out.println(counter.incrementAndGet());
				((CounterThread) Thread.currentThread()).addToCounts(counter.get());
			}
		} finally {
			lock.unlock();
		}
	}

	@Override
	public void run() {
		try {
			while (isCounting()) {
				incrementCounter();
			}
		} finally {
			((CounterThread) Thread.currentThread()).displayContents();
		}
	}

	private boolean isCounting() {
		return counter.get() < 100;
	}

}
