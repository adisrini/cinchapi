package exercise_b;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * A JUnit Tester to ascertain correct functionality of the implementation. Includes testing for insertion and
 * containment.
 * 
 * @author Aditya Srinivasan
 *
 */
public class ExerciseBTest {
	
	private IStructure myStructure;
	
	/**
	 * Initializes the structure
	 */
	@Before
	public void setUp() {
		myStructure = new ConcreteStructure();
		myStructure.initializeStructure();
	}
    
	/**
	 * Checks whether the size of the data structure increases as a result of adding values.
	 */
    @Test
    public void testInsertionWithSize() {
    	setUp();
    	System.out.println("Testing insert() to the structure with size()");
    	assertEquals("Size should begin as zero", 0, myStructure.size());
    	for(int i = 1; i <= 10; i++) {
    		myStructure.insert(i*100);
    	}
    	myStructure.head(10);
    	assertEquals("Size should now be 10", 10, myStructure.size());
    	System.out.println("Success!");
    	System.out.println();
    	System.out.println("=============================================");
    }
    
    /**
     * Checks whether retrieving elements that are inserted are correct.
     */
    @Test
    public void testInsertionWithGet() {
    	setUp();
    	System.out.println("Testing insert() to the structure with get()");
    	assertEquals("Retrieving any value should be zero", 0, myStructure.get(0));
    	myStructure.insert(1234);
    	myStructure.head(10);
    	assertEquals("First element should be 1234", 1234, myStructure.get(0));
    	System.out.println("Success!");
    	System.out.println();
    	System.out.println("=============================================");
    }
    
    /**
     * Checks whether element containment can be detected by inserting them first.
     */
    @Test
    public void testContains() {
    	setUp();
    	System.out.println("Testing contains() to the structure");
    	assertEquals("Structure should not contain any values initially", false, myStructure.contains(1000));
    	myStructure.insert(1000);
    	assertEquals("Structure should contain 1000", true, myStructure.contains(1000));
    	System.out.println("Success!");
    	System.out.println();
    	System.out.println("=============================================");
    }
    
    /**
     * Checks whether insertion returns {@code false} if the value already exists.
     */
    @Test
    public void testInsertionWithDuplicate() {
    	setUp();
    	System.out.println("Testing insert() of duplicate value");
    	assertEquals("Structure should be able to take in values", true, myStructure.insert(123));
    	assertEquals("Structure should NOT be able to take in same value (duplicate)", false, myStructure.insert(123));
    	System.out.println("Success!");
    	System.out.println();
    	System.out.println("=============================================");
    }
    
}