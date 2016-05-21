package application;

import java.util.Scanner;
import common.IExerciseDemo;

public class Main {

	public static void main(String args[]) throws Exception {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Choose an exercise to run (A, B), or quit (Q): ");
			String exercise = scanner.next();

			if (exercise.equals("Q")) {
				scanner.close();
				break;
			}

			try {
				String className = String.format("exercise_%s.Exercise%s", exercise.toLowerCase(),
																		   exercise.toUpperCase());
				Class<?> clazz = Class.forName(className);
				IExerciseDemo exerciseDemo = (IExerciseDemo) clazz.getConstructor().newInstance();
				exerciseDemo.executeDemo();
			} catch (Exception e) {
				System.out.println("That's an invalid choice.");
			}
		}
	}

}
