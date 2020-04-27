package calculator;

public interface Calculator {

	public void put(Math math) throws InvalidSequenceException;

	public void clear();

	public String getVerbose();

}
