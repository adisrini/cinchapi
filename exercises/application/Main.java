package application;

import java.util.Scanner;
import common.IExerciseDemo;

/**
 * The entry point to the program. Allows the user to select the exercise to run, or to quit the demonstration
 * if desired.
 * 
 * @author Aditya Srinivasan
 *
 */
public class Main {

	/**
	 * Establishes the prompt loop.
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Choose an exercise to run (A, B), or quit (Q): ");
			String exercise = scanner.next();

			if (exercise.toUpperCase().equals("Q")) {
				scanner.close();
				break;
			}

			try {
				runExercise(exercise);
			} catch (Exception e) {
				System.out.println("That's an invalid choice.");
			}
		}
	}

	/**
	 * Reflection is used to determine the correct exercise test to run.
	 * This allows for a fair amount of extensibility: adding new demonstrations merely requires the programmer
	 * to create new packages and files, and update the prompt message. Other than that, the process of
	 * instantiating the proper IExerciseDemo subclass and executing the demo is automated.
	 * 
	 * @param exercise: the name of the exercise to run (ex: "A", "B", etc.)
	 * @throws Exception
	 */
	private static void runExercise(String exercise) throws Exception {
		String className = String.format("exercise_%s.Exercise%s", exercise.toLowerCase(), exercise.toUpperCase());
		Class<?> clazz = Class.forName(className);
		IExerciseDemo exerciseDemo = (IExerciseDemo) clazz.getConstructor().newInstance();
		exerciseDemo.executeDemo();
	}

}
