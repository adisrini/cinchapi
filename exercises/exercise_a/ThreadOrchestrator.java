package exercise_a;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * An implementation of the runnable interface to orchestrate the thread-safe counter. The class uses a
 * CountDownLatch to synchronize the initialization of all the threads. The threads are also read in from
 * a text file of carriage-return separated values indicating the names of each thread. In this way, the
 * number of threads can be easily changed by adding or subtracting lines from the text file, and thread
 * names can be easily specified. A reentrant lock is also used to maximize usage by calling upon the least-
 * recently used thread. This allows for interleaving of responsibilities and allows for efficient parallelism.
 * 
 * @author Aditya Srinivasan
 *
 */
public class ThreadOrchestrator implements Runnable {

	private static final String THREAD_PROPERTIES_FILE_NAME = "threads.txt";
	private static final String DELIMITER = "\n";
	private static final int COUNT = 100;

	private Thread mainThread;
	private Collection<Thread> threads;
	private AtomicInteger counter;
	private ReentrantLock lock;
	private CountDownLatch latch;

	/**
	 * Instantiates the reentrant and atomic counter.
	 */
	public ThreadOrchestrator() {
		lock = new ReentrantLock(true);
		counter = new AtomicInteger(0);
	}

	/**
	 * Instantiates the CountDownLatch and starts each thread that is read in from the text
	 * file. The main thread is suspended such that the main prompt loop for the program does
	 * not interrupt the counting process.
	 */
	@SuppressWarnings("deprecation")
	void initializeThreads() {
		try {
			readThreadsToList();
			latch = new CountDownLatch(1);
			mainThread = Thread.currentThread();
			threads.forEach(Thread::start);
			mainThread.suspend();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Parses a text file of carriage-return separated values in order to populate a
	 * list of threads. For example, the following text file would create three threads
	 * of names "A", "B", and "C":
	 * 
	 * || start of file ||
	 * A
	 * B
	 * C
	 * || end of file ||
	 */
	private void readThreadsToList() {
		threads = new ArrayList<>();
		InputStream input = this.getClass().getResourceAsStream(THREAD_PROPERTIES_FILE_NAME);
		try (Scanner reader = new Scanner(input)) {
			reader.useDelimiter(DELIMITER);
			while (reader.hasNext()) {
				Thread countThread = new CounterThread(this, reader.next());
				threads.add(countThread);
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Increments the counter and calls on the currently operating thread to add the current
	 * count number to its list of counts.
	 */
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

	/**
	 * Counts down the latch to trigger all threads, and runs the incrementCounter() function.
	 * After everything has completed, calls on all threads to display their contents and
	 * resumes the main thread to continue the prompt loop of the program.
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		try {
			latch.countDown();
			while (isCounting()) {
				incrementCounter();
			}
		} finally {
			((CounterThread) Thread.currentThread()).displayContents();
			mainThread.resume();
		}
	}

	/**
	 * Determines whether the counter should still run
	 * @return
	 */
	private boolean isCounting() {
		return counter.get() < COUNT;
	}
	
	/**
	 * Returns all threads of the program (except main).
	 * @return
	 */
	Collection<Thread> getThreads() {
		return threads;
	}

}
