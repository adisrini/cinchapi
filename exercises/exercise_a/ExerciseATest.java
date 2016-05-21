package exercise_a;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A JUnit Tester to ascertain correct functionality of the implementation. Includes testing for running
 * and checking for distinct subsets.
 * 
 * @author Aditya Srinivasan
 *
 */
public class ExerciseATest {

	private ThreadOrchestrator orchestrator;
	
	@Before
	public void setUp() {
		orchestrator = new ThreadOrchestrator();
		orchestrator.initializeThreads();
	}
	
	@Test
	public void testRun() {
		System.out.println("Testing run...");
		setUp();
		System.out.println("Success!\n==============================\n");
	}
	
	@Test
	public void testSubsets() {
		System.out.println("Testing distinct subsets...");
		setUp();
		Collection<Integer> threadACounts = ((CounterThread) ((List<Thread>) orchestrator.getThreads()).get(0)).getCounts();
		Collection<Integer> threadBCounts = ((CounterThread) ((List<Thread>) orchestrator.getThreads()).get(1)).getCounts();
		Collection<Integer> threadCCounts = ((CounterThread) ((List<Thread>) orchestrator.getThreads()).get(2)).getCounts();
		List<Integer> ABintersection = threadACounts.stream()
													.filter(threadBCounts::contains)
													.collect(Collectors.toList());
		List<Integer> ACintersection = threadACounts.stream()
													.filter(threadCCounts::contains)
													.collect(Collectors.toList());
		List<Integer> BCintersection = threadBCounts.stream()
													.filter(threadCCounts::contains)
													.collect(Collectors.toList());
		assertEquals("Threads A and B should have no overlap in counts.", 0, ABintersection.size());
		assertEquals("Threads A and C should have no overlap in counts.", 0, ACintersection.size());
		assertEquals("Threads B and C should have no overlap in counts.", 0, BCintersection.size());
		System.out.println("Success!\n==============================\n");
	}
    
}