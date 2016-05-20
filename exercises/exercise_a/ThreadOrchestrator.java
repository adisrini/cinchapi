package exercise_a;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class ThreadOrchestrator implements Runnable {
	
	private static final String THREAD_PROPERTIES_FILE_NAME = "threads.txt";
	private static final String DELIMITER = "\n";

	private Collection<Thread> threads;
	
	void initializeThreads() {
		threads = new ArrayList<>();
		InputStream input = this.getClass().getResourceAsStream(THREAD_PROPERTIES_FILE_NAME);
		try(Scanner reader = new Scanner(input)) {
			reader.useDelimiter(DELIMITER);
			while(reader.hasNext()) {
				threads.add(new CounterThread(this, reader.next()));
			}
			reader.close();
		} catch(Exception e) {
			throw e;
		}
	}

	@Override
	public void run() {
		System.out.println("hello");
	}

}
