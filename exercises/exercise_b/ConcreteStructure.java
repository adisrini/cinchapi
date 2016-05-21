package exercise_b;

public class ConcreteStructure implements IStructure {
	
	private static final int CAPACITY = 16000000;
	
	private long[] values;
	private int index;
	
	public ConcreteStructure() {
		initializeStructure();
	}
	
	private void initializeStructure() {
		if(values == null) {
			values = new long[CAPACITY];
			index = 0;
		}
	}

	@Override
	public boolean insert(long value) {
		if(index < CAPACITY && !contains(value)) {
			values[index++] = value;
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(long value) {
		for(long v : values) {
			if(v == value) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Methods for testing purposes
	 */
	
	@Override
	public void head(int n) {
		System.out.print("VALUES: ");
		for(int i = 0; i < n; i++) {
			System.out.print(values[i] + " ");
		}
		System.out.println();
	}
	
	@Override
	public int size() {
		return index;
	}

	@Override
	public long get(int index) {
		return values[index];
	}

}
