package application;

import common.IExerciseDemo;
import exercise_a.ExerciseA;

public class Main {
	
	public static void main(String args[]) {
		IExerciseDemo exA = new ExerciseA();
		exA.executeDemo();
	}

}
