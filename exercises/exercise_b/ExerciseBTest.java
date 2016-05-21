package exercise_b;

import static org.junit.Assert.*;
import org.junit.Test;

public class ExerciseBTest {
	
	private IStructure myStructure;
    
    @Test
    public void testInsertionWithSize() {
    	myStructure = new ConcreteStructure();
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
    
    @Test
    public void testInsertionWithGet() {
    	myStructure = new ConcreteStructure();
    	System.out.println("Testing insert() to the structure with get()");
    	assertEquals("Retrieving any value should be zero", 0, myStructure.get(0));
    	myStructure.insert(1234);
    	myStructure.head(10);
    	assertEquals("First element should be 1234", 1234, myStructure.get(0));
    	System.out.println("Success!");
    	System.out.println();
    	System.out.println("=============================================");
    }
    
    @Test
    public void testContains() {
    	myStructure = new ConcreteStructure();
    	System.out.println("Testing contains() to the structure");
    	assertEquals("Structure should not contain any values initially", false, myStructure.contains(1000));
    	myStructure.insert(1000);
    	assertEquals("Structure should contain 1000", true, myStructure.contains(1000));
    	System.out.println("Success!");
    	System.out.println();
    	System.out.println("=============================================");
    }
    
    @Test
    public void testInsertionWithDuplicate() {
    	myStructure = new ConcreteStructure();
    	System.out.println("Testing insert() of duplicate value");
    	assertEquals("Structure should be able to take in values", true, myStructure.insert(123));
    	assertEquals("Structure should NOT be able to take in same value (duplicate)", false, myStructure.insert(123));
    	System.out.println("Success!");
    	System.out.println();
    	System.out.println("=============================================");
    }
    
}