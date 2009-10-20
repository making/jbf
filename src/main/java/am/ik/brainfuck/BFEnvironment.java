package am.ik.brainfuck;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class BFEnvironment {
	private final String source;
	private final int sourceLength;
	private final int[] memory;
	private int pointer;
	private int current;
	private InputStream in = System.in;
	private PrintStream out = System.out;

	public BFEnvironment(String source, int memorySize) {
		this.source = source;
		sourceLength = source.length();
		memory = new int[memorySize];
		Arrays.fill(memory, 0);
		pointer = 0;
		current = 0;
	}

	public int getPointer() {
		return pointer;
	}

	public void incrementPointer() {
		pointer++;
	}

	public void decrementPointer() {
		pointer--;
	}

	public int getValue() {
		return memory[pointer];
	}

	public void setValue(int value) {
		memory[pointer] = value;
	}

	public void incrementValue() {
		memory[pointer]++;
	}

	public void decrementValue() {
		memory[pointer]--;
	}

	public int getCurrent() {
		return current;
	}

	public void incrementCurrent() {
		current++;
	}

	public void decrementCurrent() {
		current--;
	}

	public char getChar() {
		return source.charAt(current);
	}

	public boolean hasNextChar() {
		return getCurrent() < sourceLength;
	}

	public InputStream getIn() {
		return in;
	}

	public void setIn(InputStream in) {
		this.in = in;
	}

	public PrintStream getOut() {
		return out;
	}

	public void setOut(PrintStream out) {
		this.out = out;
	}

	@Override
	public String toString() {
		return "BFEnvironment [memory=" + Arrays.toString(memory)
				+ ", pointer=" + pointer + ", current=" + current + "]";
	}
}
