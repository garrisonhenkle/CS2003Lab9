package stuff;

public class DelimiterChecker {

	private StackX stack;

	public boolean check(String in) {
		// objects
		stack = new StackX(in.length());

		// variable
		char currentChar;

		// for all the characters in the input string, check for any open delimiters
		// then check for any close delimiters
		for (int i = 0; i < in.length(); i++) {
			// holds current character
			currentChar = in.charAt(i);

			// checks to see if there is an open delimiter. If there is, it is pushed on the
			// stack
			if (currentChar == '{' || currentChar == '[' || currentChar == '(')
				stack.push(in.charAt(i));

			// checks to see if there is a closed delimiter. If there is, it is checked
			// against the stack to see if there is a match
			if (currentChar == ']' || currentChar == '}' || currentChar == ')') {
				// if the stack is empty, there is no brackets to pair with, so return false
				if (stack.isEmpty() == true) {
					System.out.println("Missing left delimiter");
					return false;
				}
				// if currentChar matches with the top of the stack, pop the top value of the
				// stack off
				else if (matches(currentChar))
					stack.pop();
				// if it passes all the other checks, then the delimiters are mismatched
				else {
					System.out.println("Mismatched delimiters");
					return false;
				}
			}
		}

		// checks to see if there is any extra delimiters in the stack. If there is any
		// delimiters left, return false. Otherwise return true
		if (stack.isEmpty() == false) {
			System.out.println("Missing right delimiter");
			return false;
		} else
			return true;
	}

	// takes in an closed delimiter and returns true if the corresponding open
	// delimiter is on the top of the stack
	private boolean matches(char in) {
		if (in == '}' && stack.peek() == '{')
			return true;
		else if (in == ']' && stack.peek() == '[')
			return true;
		else if (in == ')' && stack.peek() == '(')
			return true;
		else
			return false;
	}
}