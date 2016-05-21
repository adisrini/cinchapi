package exercise_b;

import common.IExerciseDemo;

/**
 * This class runs the JUnit Test methods to demonstrate ExerciseB.
 * 
 * @author Aditya Srinivasan
 *
 */
public class ExerciseB implements IExerciseDemo {

	@Override
	public void executeDemo() {
		System.out.println("/*******************\n * Running Exercise B...\n *******************/");
		ExerciseBTest bTest = new ExerciseBTest();
		bTest.testContains();
		bTest.testInsertionWithDuplicate();
		bTest.testInsertionWithGet();
		bTest.testInsertionWithSize();
	}

}