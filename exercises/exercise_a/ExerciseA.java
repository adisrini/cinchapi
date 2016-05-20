package exercise_a;

import common.IExerciseDemo;

public class ExerciseA implements IExerciseDemo {

	@Override
	public void executeDemo() {
		System.out.println("Running Exercise A\n==================");
		ThreadOrchestrator orchestrator = new ThreadOrchestrator();
		try {
			orchestrator.initializeThreads();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}