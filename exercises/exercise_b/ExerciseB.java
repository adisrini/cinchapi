package exercise_b;

import common.IExerciseDemo;

public class ExerciseB implements IExerciseDemo {

	@Override
	public void executeDemo() {
		System.out.println("Running Exercise B\n==================");
		ExerciseBTest bTest = new ExerciseBTest();
		bTest.testContains();
		bTest.testInsertionWithDuplicate();
		bTest.testInsertionWithGet();
		bTest.testInsertionWithSize();
	}

}