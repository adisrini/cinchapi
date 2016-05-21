package exercise_a;

import common.IExerciseDemo;

/**
 * This class runs the JUnit Test methods to demonstrate ExerciseA and prints out
 * the results of the exercise.
 * 
 * @author Aditya Srinivasan
 *
 */
public class ExerciseA implements IExerciseDemo {

	@Override
	public void executeDemo() {
		System.out.println("/*******************\n * Running Exercise A...\n *******************/");
		ExerciseATest aTest = new ExerciseATest();
		try {
			aTest.testRun();
			aTest.testSubsets();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}