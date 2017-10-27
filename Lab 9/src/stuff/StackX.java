package stuff;

public class StackX {
	private int maxSize;
	private char[] stackArray;
	private int top;

	public StackX(int s) // constructor
	{
		maxSize = s;
		stackArray = new char[maxSize];
		top = -1;
	}

	public void push(char j)// put item on top of stack
	{
		stackArray[++top] = j;

	}

	public char pop() {
		return stackArray[top--];
	}

	public char peek() {
		return stackArray[top];
	}

	public boolean isEmpty() {
		return (top == -1);
	}

}